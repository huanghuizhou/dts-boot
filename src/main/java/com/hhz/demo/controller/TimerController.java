package com.hhz.demo.controller;

import com.hhz.demo.model.MongoPage;
import com.hhz.demo.model.TimerQuery;
import com.hhz.demo.model.job.KafkaJob;
import com.hhz.demo.model.timer.Executor;
import com.hhz.demo.model.timer.TimerEntity;
import com.hhz.demo.model.timer.TopicInfo;
import com.hhz.demo.service.MongoDBService;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.data.Stat;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * <p class="detail">
 * 功能:定时器
 * </p>
 *
 * @author huanghuizhou
 * @ClassName Timer controller.
 * @Version V1.0.
 * @date 2018.04.19 09:38:06
 */
@Controller
@RequestMapping("timer")
public class TimerController {

    private static final String TIMER = "Timer";
    private static final Logger logger = LoggerFactory.getLogger(TimerController.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private Scheduler scheduler;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ZkClient zkClient;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MongoDBService mongoDBService;


    /**
     * <p class="detail">
     * 功能:定时器列表
     * </p>
     *
     * @return string
     * @throws SchedulerException the scheduler exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:06
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList() {
        return "timer/timerList";
    }


    /**
     * <p class="detail">
     * 功能:启动定时器
     * </p>
     *
     * @param id :
     * @return string
     * @throws SchedulerException the scheduler exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:06
     */
    @RequestMapping(value = "{id}/startTimer", method = RequestMethod.POST)
    @ResponseBody
    public String startTimer(@PathVariable String id) {

        Query query = new Query(Criteria.where("_id").is(id));

        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        timerEntity.setStatus(true);

        //检查message格式
        if (!checkMessage(timerEntity.getMessage())) {
            return "mesError";
        }
        //检查cron格式
        if (!checkCron(timerEntity.getCorn())) {
            return "cronError";
        }

        //quartz启动执行器
        try {
            doStartTimer(timerEntity);
        } catch (SchedulerException e) {
            logger.error("timer {} failed to start", timerEntity.getName());
            return "fail";
        }
        mongoTemplate.save(timerEntity, TIMER);
        return "ok";
    }

    //quartz启动执行器
    private void doStartTimer(TimerEntity timerEntity) throws SchedulerException {
        Map<String, Object> map = new HashMap<>();
        map.put("kafkaTemplate", kafkaTemplate);
        SimpleDateFormat sdf = new SimpleDateFormat(timerEntity.getMessage());
        map.put("sdf", sdf);
        JobDetail job = newJob(KafkaJob.class).usingJobData(new JobDataMap(map))
                .usingJobData("topic", timerEntity.getTopic())
                .withIdentity("Timer_" + timerEntity.getTopic())
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger_" + timerEntity.getTopic())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(timerEntity.getCorn()))
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    /**
     * <p class="detail">
     * 功能:停止定时器
     * </p>
     *
     * @param id :
     * @return string
     * @throws SchedulerException the scheduler exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:06
     */
    @RequestMapping(value = "{id}/stopTimer", method = RequestMethod.POST)
    @ResponseBody
    public String stopTimer(@PathVariable String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        timerEntity.setStatus(false);
        try {
            doStopTimer(timerEntity);
        } catch (SchedulerException e) {
            logger.error("timer {} stop fail", timerEntity.getName());
            return "fail";
        }
        mongoTemplate.save(timerEntity, TIMER);
        return "ok";
    }

    //quartz停止执行器
    private void doStopTimer(TimerEntity timerEntity) throws SchedulerException {
        JobDetail job = newJob(KafkaJob.class)
                .withIdentity("Timer_" + timerEntity.getTopic())
                .build();
        scheduler.deleteJob(job.getKey());
    }

    /**
     * <p class="detail">
     * 功能：定时器列表会异步访问这个方法来获取需要的数据
     * </p>
     *
     * @return
     * @throws Exception the exception
     * @author huanghuizhou
     * @date 2017.02.23 14:24:09
     */
    @ResponseBody
    @RequestMapping(value = "loadTimerList", method = RequestMethod.GET)
    public Map<String, Object> loadTimerList(TimerQuery timerQuery, Integer pageSize, Integer pageNum) {


        Query query = new Query();
        Criteria criteria = new Criteria();
        //根据createTime降序排序
        query.with(new Sort(Sort.Direction.DESC, "createTime"));

        //↓↓↓↓↓↓↓↓↓↓设置查询参数↓↓↓↓↓↓↓↓↓↓
        if (StringUtils.isNotBlank(timerQuery.getTimerName())) {
            criteria.and("name").regex(".*" + timerQuery.getTimerName() + ".*");
        }
        if (StringUtils.isNotBlank(timerQuery.getTopic())) {
            criteria.and("topic").regex(".*" + timerQuery.getTopic() + ".*");
        }
        if (StringUtils.isNotBlank(timerQuery.getDescribe())) {
            criteria.and("describe").regex(".*" + timerQuery.getDescribe() + ".*");
        }

        if (timerQuery.getTimeBeg() != null && timerQuery.getTimeEnd() != null) {
            criteria.and("createTime").gt(timerQuery.getTimeBeg()).lte(timerQuery.getTimeEnd());
        }
        if (timerQuery.getTimeBeg() != null && timerQuery.getTimeEnd() == null) {
            criteria.and("createTime").gt(timerQuery.getTimeBeg());
        }
        if (timerQuery.getTimeEnd() != null && timerQuery.getTimeBeg() == null) {
            criteria.and("createTime").lte(timerQuery.getTimeEnd());
        }

        //↑↑↑↑↑↑↑↑↑↑设置查询参数↑↑↑↑↑↑↑↑↑↑

        query.addCriteria(criteria);
        MongoPage<TimerEntity> mongoPage = new MongoPage<>();
        mongoPage.setPageNum(pageNum);
        mongoPage.setPageSize(pageSize);

        mongoDBService.findPage(query, mongoPage, TimerEntity.class, TIMER);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("rows", mongoPage.getList());
        jsonMap.put("total", mongoPage.getTotal());
        return jsonMap;
    }


    /**
     * <p class="detail">
     * 功能:跳转到修改定时器页面
     * </p>
     *
     * @param model :
     * @param id    :
     * @return string
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "{id}/editTimer")
    public String editTimer(Model model, @PathVariable String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        model.addAttribute("timer", timerEntity);
        return "/timer/timerEdit";
    }

    /**
     * <p class="detail">
     * 功能:修改定时器
     * </p>
     *
     * @param timerEntity :
     * @param id          :
     * @return string
     * @throws SchedulerException the scheduler exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "{id}/doEditTimer", method = RequestMethod.POST)
    @ResponseBody
    public String doEditTimer(TimerEntity timerEntity, @PathVariable String id) {

        //检查message格式
        if (!checkMessage(timerEntity.getMessage())) {
            return "mesError";
        }
        //检查cron格式
        if (!checkCron(timerEntity.getCorn())) {
            return "cronError";
        }


        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity oldTimerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);

        try {
            //如果老的topic启用中则停用
            if (oldTimerEntity.getStatus()) {
                doStopTimer(oldTimerEntity);
            }
            //如果新的topic启用则开启
            if (timerEntity.getStatus()) {
                doStartTimer(timerEntity);
            }
        } catch (SchedulerException e) {
            logger.error("timer {} update fail", timerEntity.getName());
            return "fail";
        }
        timerEntity.set_id(id);
        timerEntity.setCreateTime(sdf.format(new Date()));
        mongoTemplate.save(timerEntity, TIMER);
        return "ok";
    }

    /**
     * <p class="detail">
     * 功能:跳转到新增定时器页面
     * </p>
     *
     * @return string
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "/addTimer")
    public String addTimer() {
        return "timer/timerAdd";
    }


    /**
     * <p class="detail">
     * 功能:新增定时器
     * </p>
     *
     * @param timerEntity :
     * @return string
     * @throws SchedulerException the scheduler exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "doAddTimer")
    @ResponseBody
    public String doAddTimer(TimerEntity timerEntity) {
        //检查message格式
        if (!checkMessage(timerEntity.getMessage())) {
            return "mesError";
        }
        //检查cron格式
        if (!checkCron(timerEntity.getCorn())) {
            return "cronError";
        }

        //判断是否存在topic 目前允许存在相同topic
      /*  Query query = new Query(Criteria.where("topic").is(timerEntity.getTopic()));
        query.addCriteria(Criteria.where("delStatus").is(false));
        if (mongoTemplate.exists(query, TimerEntity.class, TIMER)) {
            logger.info("Topic {} is exist", timerEntity.getTopic());
            return timerEntity.getTopic() + " is exist";
        }
*/

        timerEntity.setTopic(timerEntity.getTopic());
        timerEntity.setCreateTime(sdf.format(new Date()));
        mongoTemplate.insert(timerEntity, TIMER);

        if (timerEntity.getStatus()) {
            //quartz启动执行器
            try {
                doStartTimer(timerEntity);
            } catch (SchedulerException e) {
                logger.error("timer {} start fail", timerEntity.getName());
                return "fail";
            }
        }
        return "ok";
    }


    /**
     * <p class="detail">
     * 功能:删除定时器
     * </p>
     *
     * @param id :
     * @return string
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "{id}/delTimer", method = RequestMethod.GET)
    @ResponseBody
    public String delTimer(@PathVariable String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        //未停用的定时器不能删除
        if (timerEntity.getStatus()) {
            return "fail";
        } else {
            mongoTemplate.remove(timerEntity, TIMER);
            return "ok";
        }
    }

    /**
     * <p class="detail">
     * 功能:执行定时器
     * </p>
     *
     * @param id :
     * @return string
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "{id}/executeTimer", method = RequestMethod.GET)
    @ResponseBody
    public String executeTimer(@PathVariable String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        //检查message格式
        if (!checkMessage(timerEntity.getMessage())) {
            return "mesError";
        }
        //检查cron格式
        if (!checkCron(timerEntity.getCorn())) {
            return "cronError";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(timerEntity.getMessage());
            String message = sdf.format(new Date());
            kafkaTemplate.send(timerEntity.getTopic(), message);
        } catch (RuntimeException e) {
            logger.error("fail to execute Timer {}", timerEntity.getName());
            return "fail";
        }
        return "ok";
    }


    /**
     * <p class="detail">
     * 功能:跳转到定时器详情页面
     * </p>
     *
     * @param model :
     * @param id    :
     * @return string
     * @throws ParseException the parse exception
     * @author huanghuizhou
     * @date 2018.04.19 09:38:07
     */
    @RequestMapping(value = "{id}/detailTimer")
    public String detailTimer(Model model, @PathVariable String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        TimerEntity timerEntity = mongoTemplate.findOne(query, TimerEntity.class, TIMER);
        model.addAttribute("timer", timerEntity);
        Executor executor = new Executor();

        //上次应该执行时间
        try {
            String lastExpectTime = getLastExpectTime(timerEntity.getCorn());
            executor.setLastExpectTime(lastExpectTime);
        } catch (ParseException e) {
            logger.error("cron {} is wrong ", timerEntity.getCorn());
            executor.setLastExpectTime("corn " + timerEntity.getCorn() + " is wrong");
        } catch (IndexOutOfBoundsException e) {
            logger.error("cron {} lastTime is not exist ", timerEntity.getCorn());
            executor.setLastExpectTime("corn " + timerEntity.getCorn() + " lastTime is not exist");
        }
        //获取所有groupId 及上次执行时间
        List<TopicInfo> topicInfos = topicToConsumerMap(timerEntity.getTopic());
        executor.setTopicInfos(topicInfos);
        model.addAttribute("executor", executor);
        return "/timer/timerDetail";
    }




    //根据corn获取理论上次执行时间
    private String getLastExpectTime(String corn) throws ParseException {
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setCronExpression(corn);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        //把统计的区间段设置为从一个月前到现在
        calendar.add(Calendar.MONTH, -1);
        List<Date> dates = TriggerUtils.computeFireTimesBetween(cronTriggerImpl, null, calendar.getTime(), now);
        return sdf.format(dates.get(dates.size() - 1));
    }


    //获取topic的所有订阅的groupId
    private List<TopicInfo> topicToConsumerMap(String timerTopic) {
        List<TopicInfo> list = new ArrayList<>();
        for (String consumer : zkClient.getChildren("/consumers")) {
            String consumerRoot = "/consumers/" + consumer + "/offsets";
            if (!zkClient.exists(consumerRoot)) {
                continue;
            }
            for (String topic : zkClient.getChildren(consumerRoot)) {
                if (!timerTopic.equals(topic)) {
                    continue;
                }
                String topicRoot = consumerRoot + "/" + topic + "/0";
                if (!zkClient.exists(topicRoot)) {
                    continue;
                }
                Stat stat = new Stat();
                zkClient.readData(topicRoot, stat);
                list.add(new TopicInfo(consumer, stat));
            }
        }
        return list;
    }


    //判断message是否符合要求
    private boolean checkMessage(String message) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(message);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    //判断cron是否符合要求
    private boolean checkCron(String cron) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cron);
            Date date = trigger.computeFirstFireTime(null);
            return date != null;
        } catch (Exception e) {
            return false;
        }
    }

}

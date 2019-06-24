package com.hhz.demo.controller;

import com.hhz.demo.model.job.KafkaJob;
import com.hhz.demo.model.timer.TimerEntity;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * <p class="detail">
 * 功能:根据mongodb 初始化定时器
 * </p>
 *
 * @author huanghuizhou
 * @ClassName Timer init.
 * @Version V1.0.
 * @date 2018.04.26 09:28:54
 */
public class TimerInit implements InitializingBean {

    private static final String TIMER = "Timer";
    private static final Logger logger = LoggerFactory.getLogger(TimerInit.class);
    @Resource
    private Scheduler scheduler;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        Query query = new Query(Criteria.where("status").is(true));
        List<TimerEntity> timerEntities = mongoTemplate.find(query, TimerEntity.class, TIMER);
        for (TimerEntity timerEntity : timerEntities) {
            if (timerEntity.getStatus()) {
                try {
                    doStartTimer(timerEntity);
                    logger.info("timer {} started when init", timerEntity.getName());
                } catch (Exception e) {
                    logger.error("timer {} failed to start when init", timerEntity.getName());
                }
            }
        }
    }


    //quartz启动执行器
    private void doStartTimer(TimerEntity timerEntity) throws SchedulerException {
        Map<String, Object> map = new HashMap();
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
}

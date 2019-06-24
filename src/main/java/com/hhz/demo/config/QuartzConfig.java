package com.hhz.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {


//    @Bean(name = "scheduler")
//    public Scheduler scheduler() throws SchedulerException {
//        SchedulerFactory schedulerfactory = new StdSchedulerFactory("scheduler/quartz.clusterJob.properties");
//        return schedulerfactory.getScheduler();
//    }


    /**
     * 调度工厂
     *
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);
        return factoryBean;
    }

}

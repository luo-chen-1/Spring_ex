package com.wjj.springboottasklearing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description : 异步任务线程池的配置
 */
//配置注解
@Configuration
public class TaskConfig {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(12);
        executor.setMaxPoolSize(26);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
//        设置线程池中任务的等待时间，如果超过这个时间还没有销毁，强制销毁，以确保关闭线程
        executor.setAwaitTerminationSeconds(180);
        executor.setThreadNamePrefix("taskExecutor-");
//      拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}

package com.wjj.springboottasklearing.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description : 定时任务作业
 */
@Component
@Slf4j
public class ScheduledJobs {

//    定时注解 表示方法执行完 5s 后继续执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelay 开始：---》"+ LocalDateTime.now());
//        sleep(10*1000);
//        log.info("fixedDelay 结束：---》"+ LocalDateTime.now());
//    }

//    定时注解 表示每隔3秒
//        @Scheduled(fixedRate = 3000)
//        public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedRate 开始：---》"+ LocalDateTime.now());
//        sleep(5*1000);
//        log.info("fixedRate 结束：---》"+ LocalDateTime.now());
//    }


    @Scheduled(cron = "30 13 15 4 4 ? ")
    public void cronJob()   {
        log.info("cronJob --->"+ "luochen生日快乐");
    }


}

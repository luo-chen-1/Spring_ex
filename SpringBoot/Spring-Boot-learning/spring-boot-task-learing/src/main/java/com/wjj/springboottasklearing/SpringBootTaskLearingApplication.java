package com.wjj.springboottasklearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//允许异步
@EnableAsync
//定时
@EnableScheduling
public class SpringBootTaskLearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskLearingApplication.class, args);
    }

}

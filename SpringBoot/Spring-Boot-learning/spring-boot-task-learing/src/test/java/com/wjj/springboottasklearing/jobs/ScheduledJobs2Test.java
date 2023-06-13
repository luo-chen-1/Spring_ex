package com.wjj.springboottasklearing.jobs;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :
 */
@SpringBootTest
class ScheduledJobs2Test {

    @Resource
    private  ScheduledJobs2 scheduledJobs2;

    @Test
    public void test(){
        scheduledJobs2.generateQRCode();
    }


}
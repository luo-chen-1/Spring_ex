package com.wjj.springboottasklearing.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :
 */

@Slf4j
@SpringBootTest
class AsyncExecutorTaskTest {

    @Resource
    private AsyncExecutorTask asyncExecutorTask;

    @Test
    void testAsyncExecutorTask() throws InterruptedException {
        asyncExecutorTask.doTaskOneCallBack();
        asyncExecutorTask.doTaskTwoCallBack();
        asyncExecutorTask.doTaskThreeCallBack();
        sleep(10*1000L);
    }


}
package com.wjj.springboottasklearing.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static java.lang.System.currentTimeMillis;


/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :
 */

@SpringBootTest
@Slf4j
class SyncTaskTest {

    @Resource
    private SyncTask syncTask;

    @Resource
    private AsyncTask asyncTask;

    @Test
    void testSyncTask() throws InterruptedException {
        long start = currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
        //执行耗时任务
        long end = currentTimeMillis();
        log.info("完成所有任务，总耗时" + (end-start)+"毫秒");
    }


    @Test
    void testASyncTask() throws InterruptedException {
        long start = currentTimeMillis();
//        异步并发执行
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        long end = currentTimeMillis();
        log.info("完成所有任务，总耗时" + (end-start)+"毫秒");
    }

}
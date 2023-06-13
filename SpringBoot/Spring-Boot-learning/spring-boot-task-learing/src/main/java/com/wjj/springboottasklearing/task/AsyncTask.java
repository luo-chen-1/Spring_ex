package com.wjj.springboottasklearing.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :异步调用子类
 */

@Component
public class AsyncTask extends AbstractTask{

    @Override
    @Async
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }

    @Override
    @Async
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}

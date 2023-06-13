package com.wjj.springboottasklearing.task;

import org.springframework.stereotype.Component;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :
 */

@Component
public class SyncTask extends AbstractTask{

    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }

    @Override
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}

package com.wjj.springboottasklearing.jobs;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author :wjj
 * @date : 2023/4/4
 * @Description :
 */
@Component
@Slf4j
public class ScheduledJobs2 {
    private int a = 'a';
    @Scheduled(fixedDelay = 1000 * 10)
    public void generateQRCode() {
        QrCodeUtil.generate(String.valueOf(a), 300, 300, FileUtil.file("D:/图片/作业/1.jpg"));
        log.info("生成字母"+a+"二维码");
        a++;
    }

}

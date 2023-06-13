package com.wjj.aopandlog.AOP.aspect;

/**
 * @author :wjj
 * @date : 2023/4/3
 * @Description :
 */
public class MyAspect {

    public void checkPermissions() {
        System.out.println("模拟检查权限...");
    }

    public void log() {
        System.out.println("模拟记录日志...");
    }

}

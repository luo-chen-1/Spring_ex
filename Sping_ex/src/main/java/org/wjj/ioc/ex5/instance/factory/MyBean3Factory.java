package org.wjj.ioc.ex5.instance.factory;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description 实例工厂方式实例化
 */
public class MyBean3Factory {

    public MyBean3Factory() {
        System.out.println("Bean3工厂实例化中");
    }

    public Bean3 creatBean(){
        return new Bean3();
    }
}

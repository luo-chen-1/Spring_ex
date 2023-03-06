package org.wjj.ioc.ex5.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class InstanceTest1 {
//构造器的实例化
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        Bean1 bean1 = context.getBean("bean1",Bean1.class);
        System.out.println(bean1);
    }

}

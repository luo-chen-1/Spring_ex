package org.wjj.ioc.ex5.instance.static_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class InstanceTest2 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("" +
                "beans2.xml");
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println(bean2);

    }

}

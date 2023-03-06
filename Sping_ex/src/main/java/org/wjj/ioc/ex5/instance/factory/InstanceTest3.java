package org.wjj.ioc.ex5.instance.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
public class InstanceTest3 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("" +
                "beans3.xml");
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println(bean3);
    }


}

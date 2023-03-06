package org.wjj.ioc.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class SchoolBagTest {


    public static void main(String[] args) {
        String xmlPath = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        SchoolBag sg1 = context.getBean("schoolBag",SchoolBag.class);
        System.out.println(sg1);
    }


}

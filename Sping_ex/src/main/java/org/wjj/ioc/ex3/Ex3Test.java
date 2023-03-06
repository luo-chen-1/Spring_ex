package org.wjj.ioc.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class Ex3Test {


    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        Person girl = context.getBean("girl", Person.class);
        girl.dress();
        Person boy = context.getBean("boy", Person.class);
        boy.dress();

    }


}

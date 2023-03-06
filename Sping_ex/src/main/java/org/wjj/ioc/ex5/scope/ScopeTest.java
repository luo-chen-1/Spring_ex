package org.wjj.ioc.ex5.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wjj.ioc.ex5.instance.main;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description : 来测试singleton,spring de Bean的作用域
 */
public class ScopeTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("" +
                        "beans4.xml");
        System.out.println(context.getBean("scope1"));
        System.out.println(context.getBean("scope1"));




    }

}

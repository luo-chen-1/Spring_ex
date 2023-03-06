package org.wjj.ioc.ex5.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
public class XmlBeanAssembleTest {

    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("" +
                "beans5.xml");
        System.out.println(context.getBean("user1"));
        System.out.println(context.getBean("user2"));
    }

}

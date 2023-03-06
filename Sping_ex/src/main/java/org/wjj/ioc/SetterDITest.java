package org.wjj.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wjj.Main;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Des
 */
public class SetterDITest {

    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService =(UserService) context.getBean(("userService"));
        userService.say();
    }

}

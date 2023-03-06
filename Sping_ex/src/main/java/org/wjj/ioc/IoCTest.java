package org.wjj.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class IoCTest {

    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.say();
    }

}

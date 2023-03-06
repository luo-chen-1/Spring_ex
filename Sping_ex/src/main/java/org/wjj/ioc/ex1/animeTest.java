package org.wjj.ioc.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class animeTest {


    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        CatDaoImpl cat = (CatDaoImpl) context.getBean("cat");
        System.out.println(cat);
        DogDaoImpl dog = (DogDaoImpl) context.getBean("dog");
        System.out.println(dog);
    }
}

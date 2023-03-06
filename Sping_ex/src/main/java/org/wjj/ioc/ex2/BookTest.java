package org.wjj.ioc.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class BookTest {

    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        Book book1 = context.getBean("book", Book.class);
        System.out.println("book对象通过默认构造器"+book1);

    }

}

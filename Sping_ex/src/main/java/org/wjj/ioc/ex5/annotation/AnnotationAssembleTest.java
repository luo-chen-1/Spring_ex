package org.wjj.ioc.ex5.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
public class AnnotationAssembleTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "/beans6.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.save();

    }

}

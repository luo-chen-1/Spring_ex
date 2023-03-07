package org.wjj.controller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.lang.annotation.Annotation;

/**
 * @author :wjj
 * @date : 2023/3/7
 * @Description :
 */
public class FirstController implements Controller {


    @Override
    public ModelAndView handleRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws Exception {
        //船舰模型视图对象
        ModelAndView mav = new ModelAndView();
        // 向
        mav.addObject("msg","我的 mvc");
        mav.addObject("person",new Person("wjj",21));

        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;

    }
}

class Person{

    public String name;
    public int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

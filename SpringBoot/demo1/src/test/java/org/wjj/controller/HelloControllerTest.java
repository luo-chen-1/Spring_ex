package org.wjj.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :wjj
 * @date : 2023/3/13
 * @Description :
 */
@SpringBootTest
class HelloControllerTest {

    @Autowired
    private  HelloController helloController;
    @Test
    void hello() {
        String hello = helloController.hello();
        System.out.println(hello);
    }
}
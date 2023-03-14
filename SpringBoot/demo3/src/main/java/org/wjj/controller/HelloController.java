package org.wjj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :wjj
 * @date : 2023/3/13
 * @Description :
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello Spring boot";
    }

}

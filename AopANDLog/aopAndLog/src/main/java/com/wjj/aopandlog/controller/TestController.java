package com.wjj.aopandlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :wjj
 * @date : 2023/4/3
 * @Description :
 */

@RestController
public class TestController {

    @GetMapping("test")
    public  String test(){
        return "Hello World";
    }

}

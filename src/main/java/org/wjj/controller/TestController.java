package org.wjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :wjj
 * @date : 2023/3/7
 * @Description :
 */

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello Spring MVC";
    }

}

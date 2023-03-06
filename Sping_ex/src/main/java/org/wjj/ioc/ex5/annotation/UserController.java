package org.wjj.ioc.ex5.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */

@Controller("userController")
public class UserController {

    @Autowired
    private UserService userService;

    public void save(){
        this.userService.save();
        System.out.println("userController...save...");

    }

}

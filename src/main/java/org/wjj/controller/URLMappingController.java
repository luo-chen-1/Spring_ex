package org.wjj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjj.entity.User;

/**
 * @author :wjj
 * @date : 2023/3/7
 * @Description :
 */

@Controller
@RequestMapping("/login")
public class URLMappingController  {

//    @GetMapping("/g")
////    @RequestMapping(value = "/g",method = RequestMethod.GET) 等同于上面
//    @ResponseBody
//    public String getMapping(String name){
//        System.out.println("name"+ name);
//        return "This is get method";
//    }

    @RequestMapping("/p")
    public String postMapping(User user, Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        return  "success";
    }



    //
//    @PostMapping("/p1")
//    @ResponseBody
//    public String postMapping1(User user){
//        System.out.println(user.getUsername()+":"+user.getPassword());
//        user.setCreateTime(new Date());
//        return  user.toString();
//    }

}

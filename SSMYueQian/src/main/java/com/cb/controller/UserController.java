package com.cb.controller;

import com.cb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;

    @RequestMapping("/getUser")
    public String getUser(Model model){
        model.addAttribute("user",user);
        return "userDetail" ;
    }
}

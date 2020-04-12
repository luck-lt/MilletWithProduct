package com.xm.controller;

import com.xm.pojo.user;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public int Login(user user) {
        List<com.xm.pojo.user> users = userService.findAll(user);
        if (users.size() != 0) {
            return 1;
        }
        return 0;
    }
}

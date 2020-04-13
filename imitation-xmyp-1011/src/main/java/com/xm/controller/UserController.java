package com.xm.controller;

import com.xm.pojo.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public int Login(User user) {
        List<User> users = userService.findAll(user);
        if (users.size() != 0) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @PostMapping("/SelectUser")
    public List<User> SelectUser() {
        List<User> users = userService.findAll(null);
        return users;
    }

    @ResponseBody
    @PostMapping("/addUser")
    public int addUser(User user) {
        System.out.println("大家好");
        List<User> users = userService.findAll(user);
        // 2:用户名重复 ，3：电话号码已注册
        if (users.size() != 0) {
            if (!users.get(0).getLogin_name().equals(null)) {
                return 2;
            } else if (!users.get(0).getTelephone().equals(null)) {
                return 0;
            }
        }
        if (userService.save(user)) {
            return 1;
        }
        return 0;
    }
}

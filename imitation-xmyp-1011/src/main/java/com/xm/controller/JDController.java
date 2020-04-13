package com.xm.controller;

import com.xm.pojo.user;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
@RestController
public class JDController {
    @Autowired
    private UserService userService;

    @GetMapping("/xmyp")
    public List<user> hello(String title, int yzm) {
        System.out.println(title + "\t\t" + yzm);
        System.out.println("你好，龙某");
        return userService.list();
    }
}

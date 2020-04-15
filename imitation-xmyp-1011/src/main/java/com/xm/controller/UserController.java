package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.pojo.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
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
    @GetMapping("/SelectUser")
    public List<User> SelectUser(User user,Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<User> users = userService.findAll(user);
        PageInfo<User> p1 = new PageInfo<User>(users, limit);
        return users;
    }

    @ResponseBody
    @PostMapping("/addUser")
    public int addUser(User user) {
        Date currentDate = new Date(System.currentTimeMillis());
        user.setRegeist_time(currentDate);
        User user1 = new User();
        User user2 = new User();
        user1.setLogin_name(user.getLogin_name());
        user2.setTelephone(user.getTelephone());

        List<User> users1 = userService.findAll(user1);
        List<User> users2 = userService.findAll(user2);
        // 2:用户名重复 ，3：电话号码已注册
        if (users1.size() != 0) {
            return 2;
        } else if (users2.size()!= 0) {
            return 3;
        }
        if (userService.save(user)) {
            return 1;
        }
        return 0;
    }
}

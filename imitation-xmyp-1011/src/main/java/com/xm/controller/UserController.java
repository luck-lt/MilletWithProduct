package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @GetMapping("/SelectUser")
    public List<User> SelectUser(Integer page) {
        PageHelper.startPage(0, 2);
        List<User> users = userService.findAll(null);
        PageInfo<User> p1 = new PageInfo<User>(users, 3);
        return users;
    }

   /* @RequestMapping(value="/ShowAllUser.action",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<User>> ShowAllUser(@RequestParam(value = "page") int page , int limit) {
        List<User> users = userService.selectAllUser(page,limit);
        //返回的总记录数
        int count=userService.findUserPageCount();
        PageResult<List<User>> listPageResult=new PageResult<List<User>>("",users,0,count);
        return listPageResult;

    }*/


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
                return 3;
            }
        }
        if (userService.save(user)) {
            return 1;
        }
        return 0;
    }
}

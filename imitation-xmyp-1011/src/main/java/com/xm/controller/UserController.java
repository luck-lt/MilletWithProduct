package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.PageResult;
import com.xm.pojo.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
            if (users.get(0).getStatus() == 0) {
                return 1;
            }
        }
        return 0;
    }

    @ResponseBody
    @GetMapping("/SelectUser")
    public PageResult<List<User>> SelectUser(User user, Integer page, Integer limit) {
        int count = userService.findAll(null).size();
        PageHelper.startPage(page, limit);
        List<User> users = userService.findAll(user);
        PageResult<List<User>> listPageResult = new PageResult<List<User>>("", users, 0, count);
        return listPageResult;
    }

    @ResponseBody
    @GetMapping("/addUser")
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
        } else if (users2.size() != 0) {
            return 3;
        }
        if (userService.save(user)) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @GetMapping("/DeleteUser")
    public int DeleteUser(Integer[] user_id, Integer id) {
        System.out.println("龙某+======================================================");
        if (id == null) {
            System.out.println("某及");
            for (int i = 0; i < user_id.length; i++) {
                int ro = userService.DeleteUser(user_id[i]);
            }
            return 1;

        } else {
            int ro = userService.DeleteUser(id);
            if (ro > 0)
                return 1;
        }

        return 0;

    }

    @ResponseBody
    @PostMapping("/UpdateUser")
    public int UpdateUser(User user) {
        int ro = userService.UpdateUser(user);
        if (ro > 0)
            return 1;
        return 0;
    }
}

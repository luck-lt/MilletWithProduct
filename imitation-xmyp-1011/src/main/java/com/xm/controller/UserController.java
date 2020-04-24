package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.PageResult;
import com.xm.pojo.Product;
import com.xm.pojo.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user1 = new User();
        User user2 = new User();
        user1.setLogin_name(user.getLogin_name());
        user2.setTelephone(user.getTelephone());
        List<User> users = userService.findAll(user1);
        List<User> users1 = userService.findAll(user2);
        // 2:用户名重复 ，3：电话号码已注册
        if (users.size() != 0) {
            if (!users.get(0).getLogin_name().equals(null)) {
                return 2;
            }
        } else if (users1.size() != 0) {
            if (!users1.get(0).getTelephone().equals(null)) {
                return 3;
            }
        }
        if (userService.save(user)) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @GetMapping("/DeleteUser")
    public int DeleteUser(Integer[] user_id, Integer id) {
        if (user_id != null) {
            for (int i = 0; i < user_id.length; i++) {
                userService.DeleteUser(user_id[i]);
            }
            return 1;
        } else if (id != null) {
            userService.DeleteUser(id);
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @PostMapping("/UpdateUser")
    public int UpdateProduct(User user) {
        int ro = userService.UpdateUser(user);
        if (ro > 0)
            return 1;
        return 0;
    }
}

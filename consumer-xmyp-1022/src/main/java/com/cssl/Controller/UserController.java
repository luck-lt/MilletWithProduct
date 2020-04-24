package com.cssl.Controller;

import com.cssl.client.UsersClient;
import com.xm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UsersClient usersClient;

    @PostMapping("/consumer/login")
    public int Login(User user) {
        System.out.println("你们好");
        return usersClient.Login(user);
    }

}

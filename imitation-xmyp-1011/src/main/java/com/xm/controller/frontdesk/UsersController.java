package com.xm.controller.frontdesk;

import com.xm.dao.UserMapper;
import com.xm.dao.verificationCodeMapper;
import com.xm.pojo.User;
import com.xm.pojo.verificationcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@RestController
public class UsersController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private verificationCodeMapper verificationCodeMapper;

    @RequestMapping("/yz")
    public String yzm(verificationcode verificationcode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", verificationcode.getPhone());
        map.put("code", verificationcode.getCode());
        List<verificationcode> list = verificationCodeMapper.selectByMap(map);
        if (list.size() != 0) {
            return "{\"zj\":" + list.get(0).getPhone() + "}";
        }
        return "{\"zj\":\"false\"}";
    }

    @PostMapping("/zc")
    public String zc(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        user.setStatus(1);
       /* String timeStr1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));*/
        user.setRegeist_time(new Date());
        user.setTelephone(user.getTelephone());
        user.setLogin_name(user.getTelephone());
        int i = userMapper.insert(user);
        if (i > 0) {
            return "true";
        }
        return "false";
    }

    @PostMapping("/dl")
    public String dl(String username, String password) {
        User user = new User();
        if (username.length() < 11) {
            user.setUser_id(Integer.parseInt(username));
        }
        user.setTelephone(username);
        user.setLogin_password(password);
        int i = userMapper.findLogin(user);
        if (i > 0) {
            return "{\"zj\":\"true\"}";
        }
        return "{\"zj\":\"false\"}";
    }
}

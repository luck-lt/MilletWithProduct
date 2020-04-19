package com.xm.controller.frontdesk;

import com.xm.pojo.User;
import com.xm.pojo.verificationcode;
import com.xm.service.UserService;
import com.xm.service.verificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@RestController
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private verificationcodeService verificationCodeMapper;

    @RequestMapping("/yz")
    public String yzm(verificationcode verificationcode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", verificationcode.getPhone());
        map.put("code", verificationcode.getCode());
        List<verificationcode> list = (List<verificationcode>) verificationCodeMapper.listByMap(map);
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
        boolean i = userService.save(user);
        if (i == true) {
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
        int i = userService.findLogin(user);
        if (i > 0) {
            return "{\"zj\":\"true\"}";
        }
        return "{\"zj\":\"false\"}";
    }
}

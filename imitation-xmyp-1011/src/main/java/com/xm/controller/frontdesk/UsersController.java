package com.xm.controller.frontdesk;

import com.xm.dao.UserMapper;
import com.xm.dao.verificationCodeMapper;
import com.xm.pojo.verificationcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        if (verificationCodeMapper.selectByMap(map).size() != 0) {
            System.out.println(verificationCodeMapper.selectByMap(map));
            return "{\"zj\":\"true\"}";
        }
        System.out.println("false");
        return "{\"zj\":\"false\"}";
    }
}

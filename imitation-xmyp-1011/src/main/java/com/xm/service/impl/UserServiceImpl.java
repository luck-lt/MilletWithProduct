package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.UserMapper;
import com.xm.pojo.user;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */

@Service
@AutoConfigureAfter({UserMapper.class})
public class UserServiceImpl extends ServiceImpl<UserMapper, user> implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<user> findAll(user user) {
        return userMapper.findAll(user);
    }
}

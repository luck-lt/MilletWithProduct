package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.UserMapper;
import com.xm.pojo.User;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */

@Service
@AutoConfigureAfter({UserMapper.class})
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> findAll(User user) {
        return userMapper.findAll(user);
    }

    @Override
    public int UpdateUser(User user) {
        return userMapper.UpdateUser(user);
    }

    @Override
    public int DeleteUser(Integer id) {
        return userMapper.DeleteUser(id);
    }

}

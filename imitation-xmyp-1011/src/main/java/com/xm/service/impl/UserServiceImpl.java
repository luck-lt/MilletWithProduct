package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.UserMapper;
import com.xm.pojo.user;
import com.xm.service.UserService;
import com.xm.dao.UserMapper;
import com.xm.pojo.user;
import com.xm.service.UserService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */

@Service
@AutoConfigureAfter({UserMapper.class})
public class UserServiceImpl extends ServiceImpl<UserMapper, user> implements UserService {

}

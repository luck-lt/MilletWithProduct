package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.user;

import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
public interface UserService extends IService<user> {
    public List<user> findAll(user user);
}

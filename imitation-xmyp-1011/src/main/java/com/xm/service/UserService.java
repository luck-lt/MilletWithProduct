package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.User;

import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
public interface UserService extends IService<User> {
    public List<User> findAll(User user);

    public int UpdateUser(User user);

    public int DeleteUser(Integer id);

}

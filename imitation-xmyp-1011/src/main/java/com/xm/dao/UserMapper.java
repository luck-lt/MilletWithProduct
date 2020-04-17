package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
@Mapper
public interface UserMapper extends SuperMapper<User> {
    public List<User> findAll(User user);

    public int findLogin(User user);
}

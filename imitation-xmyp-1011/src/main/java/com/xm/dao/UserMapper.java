package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
@Mapper
public interface UserMapper extends SuperMapper<user> {
   public List<user> findAll(user user);
}

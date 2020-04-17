package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Product;
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

    public int UpdateUser(User user);

    public int DeleteUser(Integer id);

    public List<Product> ProductFindAll(Product product);

    public int findLogin(User user);
}

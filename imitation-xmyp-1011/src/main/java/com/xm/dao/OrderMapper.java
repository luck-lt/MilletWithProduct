package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper extends SuperMapper<Order> {
   // public List<Order> OrderFindAll(Order order);
    public List<Map<String,Object>> OrderFindAll(Order order);

    public  int add(Order order);

    public  Order select(String oid);

    public  List<Order> listall(int id);
}

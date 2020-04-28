package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService extends IService<Order> {
    //public List<Order> OrderFindAll(Order order);
    public List<Map<String,Object>> OrderFindAll(Order order);

    public  int add(Order order);

    public  Order select(String oid);

    public  List<Order> listall(int id);
}

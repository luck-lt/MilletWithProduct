package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.OrderMapper;
import com.xm.dao.ProductMapper;
import com.xm.dao.UserMapper;
import com.xm.pojo.Order;
import com.xm.pojo.Product;
import com.xm.service.OrderService;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({OrderMapper.class})
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    public OrderMapper orderMapper;


    @Override
    public List<Map<String, Object>> OrderFindAll(Order order) {
        return orderMapper.OrderFindAll(order);
    }

    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }

    @Override
    public Order select(String oid) {
        return orderMapper.select(oid);
    }

    @Override
    public List<Order> listall(int id) {
        return orderMapper.listall(id);
    }

}

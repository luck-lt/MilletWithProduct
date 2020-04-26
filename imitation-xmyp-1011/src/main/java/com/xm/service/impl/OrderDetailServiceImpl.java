package com.xm.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.OrderDetailMapper;
import com.xm.pojo.Order;
import com.xm.pojo.OrderDetail;
import com.xm.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({OrderDetailMapper.class})
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Autowired
    public OrderDetailMapper orderDetailMapper;


    @Override
    public List<Map<String, Object>> OrderDetailFindAll(Order order) {
        return orderDetailMapper.OrderDetailFindAll(order);
    }
}

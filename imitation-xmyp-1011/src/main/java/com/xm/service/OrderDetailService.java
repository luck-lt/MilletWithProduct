package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.Category;
import com.xm.pojo.Order;
import com.xm.pojo.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailService extends IService<OrderDetail> {
    public List<Map<String,Object>> OrderDetailFindAll(Order order);

}

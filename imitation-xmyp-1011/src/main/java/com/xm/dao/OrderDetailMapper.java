package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Order;
import com.xm.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDetailMapper extends SuperMapper<OrderDetail> {
    public List<Map<String, Object>> OrderDetailFindAll(Order order);
}

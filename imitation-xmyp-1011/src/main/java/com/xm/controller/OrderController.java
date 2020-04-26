package com.xm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.pojo.Order;
import com.xm.pojo.OrderDetail;
import com.xm.service.OrderDetailService;
import com.xm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public OrderDetailService orderDetailService;

    @GetMapping("/OrderFindAll")
    public Map<String, Object> OrderFindAll(Order order, HttpSession session, Integer page, Integer limit) {

        List<Map<String, Object>> list1 = orderDetailService.OrderDetailFindAll(order);
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = orderService.OrderFindAll(order);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("list", list1);
        }
        map.put("code", 0);
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }
}
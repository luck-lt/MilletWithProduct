package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.Order;
import com.xm.pojo.OrderDetail;
import com.xm.pojo.User;
import com.xm.service.OrderDetailService;
import com.xm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> OrderFindAll(Order order, Integer page, Integer limit) {
        List<Map<String, Object>> list1 = orderDetailService.OrderDetailFindAll(null);
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        List<Map<String, Object>> list = orderService.OrderFindAll(order);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("list", list1);
        }
        map.put("code", 0);
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    @PostMapping("/OrderUpdate")
    public int OrderUpdate(Order order, User user) {
        System.out.println("年后");
        //boolean co = orderService.updateById(order);
        return 1;
       // return 0;
    }

}

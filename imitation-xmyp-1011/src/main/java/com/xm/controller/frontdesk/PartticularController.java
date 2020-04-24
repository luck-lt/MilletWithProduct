package com.xm.controller.frontdesk;

import com.xm.pojo.Product;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/22
 */
@RestController
public class PartticularController {
    @Autowired
    private ProductService productService;

    @RequestMapping("spcx")
    public Product list(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", id);
        List<Product> list = (List<Product>) productService.listByMap(map);
        return list.get(0);
    }
}


package com.xm.controller.frontdesk;

import com.xm.pojo.Category;
import com.xm.pojo.Product;
import com.xm.pojo.Products;
import com.xm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.xm.pojo.Product;
import com.xm.service.CategoryService;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping("/cd")
    @ResponseBody
    public List<Category> cd() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parent_id", 0);
        List<Category> list = (List<Category>) categoryService.listByMap(map);
        return list;
    }

    @RequestMapping("/cd2")
    @ResponseBody
    public List<Products> cd2() {
        List<Products> list = productsService.list();
        return list;
    }

    @RequestMapping("/xfcx")
    @ResponseBody
    public List<Products> xfcx(String sid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category_id", Integer.valueOf(sid));
        List<Products> list = (List<Products>) productsService.listByMap(map);
        return list;
    }

    /*查询商品全部*/

    @PostMapping("/listsp")
    @ResponseBody
    public List<Map<String, Object>> listallsp() {
        return (List<Map<String, Object>>) categoryService.listallsp();
    }
}


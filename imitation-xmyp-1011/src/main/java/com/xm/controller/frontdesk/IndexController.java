package com.xm.controller.frontdesk;

import com.xm.dao.CategoryMapper;
import com.xm.dao.ProductMapper;
import com.xm.pojo.Category;
import com.xm.pojo.Product;
import com.xm.pojo.verificationcode;
import com.xm.service.CategoryService;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/17
 */
@RestController
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

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
    public List<Product> cd2() {
        List<Product> list = productService.list();
        return list;
    }

    @RequestMapping("/xfcx")
    @ResponseBody
    public List<Product> xfcx(String sid) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category_id", Integer.valueOf(sid));
        List<Product> list = (List<Product>) productService.listByMap(map);
        return list;
    }
}

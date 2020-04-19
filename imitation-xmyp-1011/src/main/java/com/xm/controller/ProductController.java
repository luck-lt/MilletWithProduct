package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.PageResult;
import com.xm.pojo.Product;
import com.xm.pojo.User;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @ResponseBody
    @GetMapping("/ProductFindAll")
    public PageResult<List<Product>> ProductFindAll(Product product, Integer page, Integer limit) {
        int count = productService.list(null).size();
        PageHelper.startPage(page, limit);
        List<Product> products = productService.ProductFindAll(product);
        PageResult<List<Product>> listPageResult = new PageResult<List<Product>>("", products, 0, count);
        return listPageResult;
    }
}

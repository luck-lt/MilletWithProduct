package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.Category;
import com.xm.pojo.PageResult;
import com.xm.pojo.Product;
import com.xm.pojo.User;
import com.xm.service.CategoryService;
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
    @Autowired
    public CategoryService categoryService;

    @ResponseBody
    @GetMapping("/ProductFindAll")
    public PageResult<List<Product>> ProductFindAll(Product product, Integer page, Integer limit) {
        int count = productService.ProductFindAll(null).size();
        PageHelper.startPage(page, limit);
        List<Category> categoryList = categoryService.CategoryFindAll(null);
        System.out.println(categoryList.size() + ":=====================================================");
        List<Product> products = productService.ProductFindAll(product);
        for (int i=0;i<categoryList.size();i++) {
            Category category = new Category();
            Category category2 = new Category();
            category.setParent_id(categoryList.get(i).category_id);
            List<Category> list = categoryService.CategoryFindAll(category);
            category2.setList(list);
            categoryList.add(category2);
        }
        PageResult<List<Product>> listPageResult = new PageResult<List<Product>>("", products, 0, count, categoryList);
        return listPageResult;
    }
}

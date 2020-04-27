package com.xm.controller;

import com.github.pagehelper.PageHelper;
import com.xm.pojo.Category;
import com.xm.pojo.PageResult;
import com.xm.pojo.Product;
import com.xm.service.CategoryService;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;
    @Autowired
    public CategoryService categoryService;

    @ResponseBody
    @GetMapping("/ProductFindAll")
    public PageResult<List<Product>> ProductFindAll(Product product, Integer page, Integer limit, HttpSession session) {
        int count = productService.ProductFindAll(product).size();
        PageHelper.startPage(page, limit);
        List<Product> products = productService.ProductFindAll(product);
        PageResult<List<Product>> listPageResult = new PageResult<List<Product>>("", products, 0, count);
        return listPageResult;
    }

    @ResponseBody
    @PostMapping("/UpdateProduct")
    public int UpdateProduct(Product product) {
        int ro = productService.UpdateProduct(product);
        if (ro > 0)
            return 1;
        return 0;
    }

    @ResponseBody
    @PostMapping("/AddProduct")
    public int AddProduct(Product product) {
        if (productService.save(product)) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @GetMapping("/DeleteProduct")
    public int DeleteProduct(Integer[] product_id, Integer id) {
        if (product_id != null) {
            for (int i = 0; i < product_id.length; i++) {
                productService.DeleteProduct(product_id[i]);
            }
            return 1;
        } else if (id != null) {
            productService.DeleteProduct(id);
            return 1;
        }
        return 0;
    }

    //根据id查询
    @ResponseBody
    @PostMapping("/ProductById")
    public int ProductById(Integer id) {
        Product product = new Product();
        product.setCategory_id(id);
        List<Product> list = productService.ProductFindAll(product);
        if (list.size() != 0) {
            return 1;
        }
        return 0;
    }


}

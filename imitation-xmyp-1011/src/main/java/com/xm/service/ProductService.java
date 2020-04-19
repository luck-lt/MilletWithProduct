package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.Product;
import com.xm.pojo.User;

import java.util.List;

public interface ProductService extends IService<Product> {
    public List<Product> ProductFindAll(Product product);
    public int UpdateProduct(Product product);
    public int DeleteProduct(Integer id);
}

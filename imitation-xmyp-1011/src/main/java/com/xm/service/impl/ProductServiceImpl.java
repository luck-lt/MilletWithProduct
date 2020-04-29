package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.ProductMapper;
import com.xm.dao.UserMapper;
import com.xm.pojo.Product;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({UserMapper.class})
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    public ProductMapper productMapper;

    @Override
    public List<Product> ProductFindAll(Product product) {
        return productMapper.ProductFindAll(product);
    }

    @Override
    public int UpdateProduct(Product product) {
        return productMapper.UpdateProduct(product);
    }

    @Override
    public int DeleteProduct(Integer id) {
        return productMapper.DeleteProduct(id);
    }



}

package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.ProductMapper;
import com.xm.dao.ProductsMapper;
import com.xm.dao.UserMapper;
import com.xm.pojo.Product;
import com.xm.pojo.Products;
import com.xm.service.ProductService;
import com.xm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({ProductsService.class})
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

    @Autowired
    public ProductsMapper productsMapper;

    @Override
    public int updatecount(int pid, int count) {
        return productsMapper.updatecount(pid, count);
    }

    @Override
    public List<Products> listTop10() {
        return productsMapper.listTop10();
    }
}

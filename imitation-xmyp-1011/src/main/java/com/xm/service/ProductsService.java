package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.Product;
import com.xm.pojo.Products;

import java.util.List;

public interface ProductsService extends IService<Products> {
    public int updatecount(int pid, int count);

    public List<Products> listTop10();
}

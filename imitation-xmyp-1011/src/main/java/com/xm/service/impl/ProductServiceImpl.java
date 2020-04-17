package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.ProductMapper;
import com.xm.dao.UserMapper;
import com.xm.pojo.Product;
import com.xm.pojo.User;
import com.xm.service.ProductService;
import com.xm.service.UserService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter({UserMapper.class})
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}

package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.CategoryMapper;
import com.xm.dao.addressMapper;
import com.xm.pojo.Category;
import com.xm.pojo.address;
import com.xm.service.CategoryService;
import com.xm.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({CategoryMapper.class})
public class addressServiceImpl extends ServiceImpl<addressMapper, address> implements addressService {

    @Autowired
    public addressMapper addressMapper;


}

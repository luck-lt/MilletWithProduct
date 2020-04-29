package com.xm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.shoppingMapper;
import com.xm.pojo.shopping;
import com.xm.service.shoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */

@Service
@AutoConfigureAfter({shoppingMapper.class})
public class shoppingServiceImpl extends ServiceImpl<shoppingMapper, shopping> implements shoppingService {

    @Autowired
    public shoppingMapper shoppingMapper;

    @Override
    public int update(shopping shopping) {
        return shoppingMapper.update(shopping);
    }

    @Override
    public int updatecount(shopping shopping) {
        return shoppingMapper.updatecount(shopping);
    }

    @Override
    public List<Map<String, Object>> mapList(int id) {
        return shoppingMapper.mapList(id);
    }
}

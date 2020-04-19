package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.CategoryMapper;
import com.xm.pojo.Category;
import com.xm.service.CategoryService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: Specime
 * @date:2020/4/17
 */
@Service
@AutoConfigureAfter({CategoryMapper.class})
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}

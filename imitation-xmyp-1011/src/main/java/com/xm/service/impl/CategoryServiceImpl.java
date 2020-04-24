package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.CategoryMapper;
import com.xm.dao.ProductMapper;
import com.xm.dao.UserMapper;
import com.xm.pojo.Category;
import com.xm.pojo.Product;
import com.xm.service.CategoryService;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({CategoryMapper.class})
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public List<Category> CategoryFindAll(Category category) {
        return categoryMapper.CategoryFindAll(category);
    }

    @Override
    public List<Category> CategoryParFindAll(int id) {
        return categoryMapper.CategoryParFindAll(id);
    }

    @Override
    public int UpdateCategory(Category category) {
        return categoryMapper.UpdateCategory(category);
    }

    @Override
    public int DeleteCategory(Integer id) {
        return categoryMapper.DeleteCategory(id);
    }
}

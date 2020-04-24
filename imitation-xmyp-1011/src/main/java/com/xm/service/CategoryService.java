package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.Category;
import com.xm.pojo.Product;

import java.util.List;

public interface CategoryService extends IService<Category> {
    public List<Category> CategoryFindAll(Category category);
    public List<Category> CategoryParFindAll(int id);
    public int UpdateCategory(Category category);
    public int DeleteCategory(Integer id);


}

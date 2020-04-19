package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends SuperMapper<Category> {
    public List<Category> CategoryFindAll(Category category);
}

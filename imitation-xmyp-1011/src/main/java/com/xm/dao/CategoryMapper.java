package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Category;
import javafx.scene.chart.CategoryAxis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends SuperMapper<Category> {
    public List<Category> CategoryFindAll(Category category);

    public List<Category> CategoryParFindAll(int id);

    public int UpdateCategory(Category category);

    public int DeleteCategory(Integer id);
}
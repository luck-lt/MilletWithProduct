package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends SuperMapper<Product> {
    public List<Product> ProductFindAll(Product product);
    public int UpdateProduct(Product product);
    public int DeleteProduct(Integer id);
}

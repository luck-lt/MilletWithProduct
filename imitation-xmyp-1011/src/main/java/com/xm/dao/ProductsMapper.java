package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Product;
import com.xm.pojo.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsMapper extends SuperMapper<Products> {

}

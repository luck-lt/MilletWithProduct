package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends SuperMapper<Product> {
}

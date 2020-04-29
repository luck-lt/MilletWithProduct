package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/25
 */
@Mapper
public interface shoppingMapper extends SuperMapper<shopping> {
    public int update(shopping shopping);

    public int updatecount(shopping shopping);

    public List<Map<String, Object>> mapList(int id);
}

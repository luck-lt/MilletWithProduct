package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.shopping;

import java.util.List;
import java.util.Map;


/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
public interface shoppingService extends IService<shopping> {
    public int update(shopping shopping);

    public int updatecount(shopping shopping);

    public List<Map<String, Object>> mapList(int id);

}

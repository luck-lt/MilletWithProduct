package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.shopping;


/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
public interface shoppingService extends IService<shopping> {
    public int update(shopping shopping);
    public int updatecount(shopping shopping);
}

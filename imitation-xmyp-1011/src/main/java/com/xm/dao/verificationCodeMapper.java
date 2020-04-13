package com.xm.dao;

import com.xm.SuperMapper;
import com.xm.pojo.verificationcode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description
 * @author: Specime
 * @date:220/4/13
 */
@Mapper
public interface verificationCodeMapper extends SuperMapper<verificationcode> {
    public int deletePhone(String phone);
}

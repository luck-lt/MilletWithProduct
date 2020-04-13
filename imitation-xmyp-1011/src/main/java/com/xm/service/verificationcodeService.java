package com.xm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xm.pojo.verificationcode;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
public interface verificationcodeService extends IService<verificationcode> {

    public int deletePhone(String phone);

}

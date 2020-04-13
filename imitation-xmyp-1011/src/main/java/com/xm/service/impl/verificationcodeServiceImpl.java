package com.xm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.dao.verificationCodeMapper;
import com.xm.pojo.verificationcode;
import com.xm.service.verificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@Service
@AutoConfigureAfter({verificationCodeMapper.class})
public class verificationcodeServiceImpl extends ServiceImpl<verificationCodeMapper, verificationcode> implements verificationcodeService {
    @Autowired
    private verificationCodeMapper verificationCodeMapper;

    public int deletePhone(String phone) {
        return verificationCodeMapper.deletePhone(phone);
    }
}

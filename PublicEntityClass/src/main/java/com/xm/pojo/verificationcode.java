package com.xm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class verificationcode {
    private String code;
    private String phone;
}

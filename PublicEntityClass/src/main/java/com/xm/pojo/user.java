package com.xm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @description
 * @author: Specime
 * @date:2020/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {

    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_status;
    private String name;
    private String phone;
    private String address;

}

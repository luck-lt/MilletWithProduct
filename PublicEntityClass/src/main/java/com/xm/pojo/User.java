package com.xm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    public Integer user_id;
    public String login_name;
    public String login_password;
    public String real_name;
    public Integer sex;
    public Integer status;
    public String telephone;
    public Date regeist_time;
}

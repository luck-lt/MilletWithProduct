package com.xm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    public Integer user_id;
    public String login_name;
    public String login_password;
    public String real_name;
    public Integer sex;
    public Integer status;
    public String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public String regeist_time;
}

package com.xm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    public Integer category_id;
    public Integer parent_id;
    public String category_name;
}

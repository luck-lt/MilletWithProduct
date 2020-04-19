package com.xm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    public Integer product_id;
    public String pname;
    public Integer stock;
    public double show_price;
    public String attribute_list;
    public Integer category_id;
    public String introduce;
    public String pic_img;

}

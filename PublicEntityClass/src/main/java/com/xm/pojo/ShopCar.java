package com.xm.pojo;

import lombok.Data;

@Data
public class ShopCar {
    public Product product;
    private int number;// 数量
    private double xiaoji;// 小计
}

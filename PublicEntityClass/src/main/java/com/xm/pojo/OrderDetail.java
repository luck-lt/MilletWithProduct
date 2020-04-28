package com.xm.pojo;

import lombok.Data;

@Data
public class OrderDetail {
    public Integer order_product_id;
    public Integer order_id;
    public Integer product_id;
    public double buy_number;//商品数量
    public Integer product_amount;//金额
}

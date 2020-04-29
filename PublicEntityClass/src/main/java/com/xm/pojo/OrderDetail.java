package com.xm.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("OrderDetail")
public class OrderDetail {
    public Integer order_product_id;
    public Integer order_id;
    public Integer product_id;
    public String lists;   //******
    public double buy_number;//商品数量
    public double product_amount;//金额   *****
}

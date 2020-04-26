package com.xm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    public Integer order_id;
    public String order_number;
    public Integer product_id;
    public String pname;
    public List<OrderDetail> orderDetailList;

}

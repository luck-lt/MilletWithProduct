package com.xm.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    public Integer order_id;
    public Integer user_id;
    public String order_number;
    public Integer product_id;
    public double order_amount;//金额
    public  String address;
    public String pname;
    public Integer order_status;
    public Date create_time;
    public List<OrderDetail> orderDetailList;

}

package com.xm.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    public Integer order_id;
    public String order_number;
    public Integer user_id;
    public double order_amount;
    public String address;
    public Integer order_status;
    public Date create_time;
    public List<OrderDetail> orderDetailList;

}

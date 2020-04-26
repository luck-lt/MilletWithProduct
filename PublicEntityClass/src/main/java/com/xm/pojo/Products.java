package com.xm.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @description
 * @author: Specime
 * @date:2020/4/25
 */
@Data
@TableName("Product")
public class Products {
    public Integer product_id;
    public String pname;
    public Integer stock;
    public double show_price;
    public Integer category_id;
    public String attribute_list;
    public String introduce;
    public String pic_img;
}

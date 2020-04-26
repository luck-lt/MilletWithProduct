package com.xm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description
 * @author: Specime
 * @date:2020/4/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    private Integer category_id;
    private int parent_id;
    private String name;


}

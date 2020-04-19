package com.xm.pojo;

import java.util.List;

public class PageResult<T> {

    private String msg;
    //返回的数据
    private  T data;
    private  int code;
    //总记录数
    private  int count;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PageResult(String msg, T data, int code, int count, List<Category> categoryList) {
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
    }
}

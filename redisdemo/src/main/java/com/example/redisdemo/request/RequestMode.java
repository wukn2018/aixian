package com.example.redisdemo.request;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author : Wukn
 * @Date : 2018/2/5
 */
public class RequestMode implements Serializable{
    private String name;
    private Integer sex;

    public RequestMode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}

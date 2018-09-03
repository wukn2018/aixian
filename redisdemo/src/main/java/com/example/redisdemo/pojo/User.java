package com.example.redisdemo.pojo;

import com.alibaba.fastjson.JSON;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author : Wukn
 * @Date : 2018/2/5
 */
public class User implements Serializable{

   // @NotBlank(message = "名称不能为空")
    private String name;

    //@Max( value = 7,message = "ddd")
    private int sex;



    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}

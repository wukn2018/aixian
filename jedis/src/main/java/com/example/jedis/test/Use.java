package com.example.jedis.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Data
public class Use {

    private String name;
    private Integer id;
    private Integer saler;

    public Use(String name, Integer id, Integer saler) {
        this.name = name;
        this.id = id;
        this.saler = saler;
    }

    public Use() {

    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}

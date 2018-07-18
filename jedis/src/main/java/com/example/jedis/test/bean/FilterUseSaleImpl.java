package com.example.jedis.test.bean;

import com.example.jedis.test.Use;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class FilterUseSaleImpl implements FilterUser<Use>{
    @Override
    public Boolean checkUser(Use o) {

        return o.getSaler()>78?true:false;
    }
}

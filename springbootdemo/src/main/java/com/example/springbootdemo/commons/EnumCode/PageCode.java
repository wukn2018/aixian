package com.example.springbootdemo.commons.EnumCode;

import com.alibaba.fastjson.JSON;

public enum PageCode {


    /**
     * Status
     */
	DRAFT("DRAFT"),
    OFFLINE("OFFLINE"),
    ONLINE("ONLINE"),


    /**
     * Type
     */
    ACTIVITY("ACTIVITY"),
    HOME("HOME"),


    /**
     * APP  MINIPROGRAM
     */
    APP("APP"),
    MINIPROGRAM("MINIPROGRAM"),

    ;
    private String name;

    PageCode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}

package com.example.jedis.exception;

/**
 * @Author : Wukn
 * @Date : 2018/6/13
 */
public class BaseException extends Exception {

    private String code;
    private String msg;

    public BaseException() {
    }

    public BaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}

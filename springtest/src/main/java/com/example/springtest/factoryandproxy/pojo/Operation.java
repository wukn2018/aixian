package com.example.springtest.factoryandproxy.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class Operation {

    //返回结果
    double result = 0;
    //除数
    private int param1 ;
    //被除数
    private int param2 ;

    public Operation() {
    }

    public Operation(int param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    /**
     * 结果
     * @return
     */
    public double getResult() {
        return result;
    }
}

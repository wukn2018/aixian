package com.example.springtest.factoryandproxy.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class RideOp extends Operation{

    private double result;

    /**
     * 乘法
     * 结果
     * @return
     */
    @Override
    public double getResult() {
        result = getParam1() * getParam2();
        return result;
    }
}

package com.example.springtest.factoryandproxy.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class AddOp extends Operation {

    private double result = 0;

    /**
     * 加法类，重写getResult()方法，重写的内容可以是业务逻辑，比如判断参数是否合法等
     * @return
     */
    @Override
    public double getResult() {
        result = getParam1()+getParam2();
        return result;
    }

}

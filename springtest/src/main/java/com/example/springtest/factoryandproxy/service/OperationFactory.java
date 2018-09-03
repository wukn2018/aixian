package com.example.springtest.factoryandproxy.service;

import com.example.springtest.factoryandproxy.pojo.*;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class OperationFactory {


    /**
     * 可以通过判断符号来生成不同的子类，这里用到的就是多态
     * @param str
     * @return
     */
    public  Operation getOperation(String str) {
        Operation operation = null;
        switch (str) {
            case "+":
                operation = new AddOp();
                break;
            case "-":
                operation = new ReduceOp();
                break;
            case "*":
                operation = new RideOp();
                break;
            case "/":
                operation = new DeleteOp();
                break;

        }
        return operation;
    }
}

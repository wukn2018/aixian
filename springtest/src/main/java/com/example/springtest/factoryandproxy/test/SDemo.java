package com.example.springtest.factoryandproxy.test;

import com.example.springtest.factoryandproxy.inter.MateInter;
import com.example.springtest.factoryandproxy.proxy.OperationLoggerProxy;
import com.example.springtest.factoryandproxy.service.MathInterImpl;
import org.junit.jupiter.api.Test;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class SDemo {

//
//    @Test
//    public void test1() {
//            Operation operation = null;
//            operation = OperationFactory.getOperation( "+" );
//            operation.setParam1( 1 );
//            operation.setParam2( 2 );
//            double result = operation.getResult();
//            System.out.println(result);
//    }


    @Test
    public void test2() {
        MateInter proxy =  new OperationLoggerProxy( new MathInterImpl() ).getOperationFactory();
        proxy.add( 1 );
        proxy.delete( "q" );

    }
}

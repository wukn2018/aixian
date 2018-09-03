package com.example.springtest.factoryandproxy.proxy;

import com.example.springtest.factoryandproxy.inter.MateInter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/
 *
 * 代理对象
 */
public class OperationLoggerProxy {
    /**
     * 需要被代理的对象
     */
    public MateInter target;

    public OperationLoggerProxy(MateInter operation) {
        this.target = operation;
    }

    public MateInter getOperationFactory() {
        MateInter operation = null;

        //代理对象由哪一个类加载器负责
        ClassLoader classLoader = target.getClass().getClassLoader();
        //代理对象的类型。即其中有哪些方法
        Class[] op = new Class[]{MateInter.class};
        //当调用代理对象其中的方法时，改执行得1代码
        InvocationHandler handler = new InvocationHandler( ) {

            /**
             *
             * @param proxy   z正在返回那个代理对象，一般情况下都不使用
             * @param method  正在被调用的方法
             * @param args     调用方式时，传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String methodName = method.getName();
                //前置  日志
                System.out.println("Logger"+methodName+ Arrays.asList( args));

                //执行方法
                Object result = null;
                try {
                    //返回  通知
                    result = method.invoke(target,args  );
                } catch (Exception e) {
                    //异常
                    e.printStackTrace( );
                }

                //后置   日志
                System.out.println(methodName+result+"");

                return result;
            }
        };
        //MateInter    这里返回的方法只能是接口
        operation = (MateInter) Proxy.newProxyInstance( classLoader,op,handler );


        return operation;
    }










}

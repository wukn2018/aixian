package com.example.springtest.AspectJDemo.Acpect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/3
 *
 * 可以使用@Order(1)指定切面的优先级，值越小，优先级越高
 *
 */
@Order(1)
@Aspect
@Component
public class VlidationAspectJ {



    /**
     * 申明该方法是一个前置通知，在目标方法执行之前
     */
    @Before(  "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))" )
    public void beforeVliationMethod(JoinPoint joinPoint) {
        //方式名称
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args =  Arrays.asList( joinPoint.getArgs() ) ;
        System.out.println(methodName+args);
        System.out.println("前置参数。。。。。。。。。");
    }



}

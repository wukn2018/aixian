package com.example.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Aspect
@Component
public class AspectJController {


    @Pointcut("execution(* com.example.springbootdemo.web.controller.*.*(..))")
    public void getPoint() {}


    /**
     * 前置通知
     * @param joinPoint
     */
    @Before( "getPoint()" )
    public void beforeMethon(JoinPoint joinPoint) {
        //方法参数
        Object[] args = joinPoint.getArgs();

        if (args.length > 1 && args[1] instanceof BindingResult) {
            BindingResult bindingResult = (BindingResult) args[1];
            /**
             * {@code bindResult} 不为空并且存在错误
             */
            Optional.ofNullable(bindingResult)
                    .filter(result -> !result.hasErrors())
                    .orElseThrow(() -> new IllegalArgumentException(bindingResult
                            .getFieldError().getDefaultMessage()));
        }
    }



}

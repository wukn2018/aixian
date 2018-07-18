package com.example.jedis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Optional;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/19
 */
@Aspect
@Component
public class ResidExceptionAdvice {

    /**
     * 对controller 入口参数进行基本校验
     * 只有第一个参数有 @Validate 注解
     *
     * @param joinPoint
     * @see org.springframework.validation.annotation.Validated
     * 第二个是 {@link BindingResult} 才管用
     */
    @Before("execution(public * com.example.jedis.controller.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();

        if (args.length > 1 && args[1] instanceof BindingResult) {
            BindingResult bindingResult = (BindingResult) args[1];
            /**
             * {@code bindResult} 不为空并且存在错误
             */
            Optional.ofNullable(bindingResult)
                    .filter(result -> !result.hasErrors())
                    .orElseThrow(() -> new Exception(bindingResult
                            .getFieldError().getDefaultMessage()));
        }
    }
}

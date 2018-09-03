package com.example.springtest.AspectJDemo.Acpect;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**把这个类申明为一个切面
 * 需要把该类放到IOC容器中，在申明一个切面
 */
@Order(2)
@Aspect
@Component
public class LoggerAcpectJ {


    /**
     * 申明该方法是一个前置通知，在目标方法执行之前
     */
    @Before(  "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))" )
    public void beforeMethod(JoinPoint joinPoint) {
        //方式名称
        String methodName = joinPoint.getSignature().getName();
        //参数
       List<Object> args =  Arrays.asList( joinPoint.getArgs() ) ;
       System.out.println(methodName+args);
        System.out.println("前置日志。。。。。。。。。");
    }


    /**
     * 后置通知，在目标方法执行后(无论改方法是否出现异常)的操作
     * 在后置通知中，还不能访问目标方法执行的结果
     */
    @After( "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))" )
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList( joinPoint.getArgs() );
        System.out.println(methodName+args);
        System.out.println("后置通知日志。。。。。。。。。。。。。。");
    }


    /**
     * 在方法正常执行后执行的代码，无论该方法是否有异常
     * returning ="result"    该方法的返回值
     */
    @AfterReturning(value = "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))",
            returning ="result")
    public void returnMethod(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList( joinPoint.getArgs() );
        System.out.println(methodName+args+result);
        System.out.println("返回通知。。。。。。");
    }



    /**
     * 目标方法出现异常时异常通知，可以访问异常对象
     * throwing ="ex"    返回的异常
     * Exception ex  这个异常可以指定特定的异常
     *
     */
   @AfterThrowing(value = "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))",throwing = "ex")
    public void MethodThrow(JoinPoint joinPoint,Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList( joinPoint.getArgs() );
        System.out.println(methodName+args+ex);
        System.out.println("返回通知。。。。。。");
    }


    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数，
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数，可以决定是否执行目标方法
     * 环绕通知必须有返回值，返回值为目标方法的返回值
     * @param point
     */
    @Around( value = "execution(* com.example.springtest.AspectJDemo.service.MathInterImpl.add(..))" )
    public Object aroundMethod(ProceedingJoinPoint point) {
        Object result = null;
        String methodName = point.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("前置通知。。。"+methodName+Arrays.asList( point.getArgs() ));
            //目标对象的返回结果
            result = point.proceed();
            //后置通知
            System.out.println("后置通知。。。"+methodName+result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("异常通知。。。"+throwable);
        }
        //后置通知
        System.out.println("环绕通知。。。。。。。。。");
        return 10086;
    }










}

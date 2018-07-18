package com.example.jedis.advice;

import com.example.jedis.exception.CMSException;
import com.example.jedis.response.ResultClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/20
 */
@ControllerAdvice
public class RedisAdvice {

    private static final Logger logger = LoggerFactory.getLogger(RedisAdvice.class);



    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public Object handleException(CMSException ex) {
        logger.error("异常,errorMsg:", ex);
        return new ResultClient<>(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception ex) {
        logger.error("handleException,errorMsg:", ex);
        return new ResultClient<>(ex.getMessage());
    }
}

package com.example.springbootdemo.advice;
import com.example.springbootdemo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description: 用来处理异常处理
 * Date: 2018-06-08
 * Time: 5:50 PM
 *
 * @author: wukn
 */
@ControllerAdvice
@Slf4j
public class CmsControllerAdvice {

    /**
     * 参数校验
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public BaseResponse illegalArgumentException(IllegalArgumentException ex) {
        log.error("illegalArgumentException ", ex);
        return BaseResponse.parameter("3",ex.getMessage());
    }


}

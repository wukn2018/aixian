package com.example.springbootdemo.response;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.commons.constants.CMSExceptionCode;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-06-08
 * Time: 5:50 PM
 *
 * @author: fanzhengchen
 */
@Data
public class BaseResponse {
    private String resultCode;
    private String resultDesc;
    private Object resultData;


    public static BaseResponse ok() {
        BaseResponse response = new BaseResponse();
        response.setResultCode("0");
        response.setResultDesc("success");
        return response;
    }

    public static BaseResponse error() {
        BaseResponse response = new BaseResponse();
        response.setResultCode("1");
        response.setResultDesc("error");
        return response;
    }

    public static BaseResponse ok(Object data) {
        BaseResponse response = ok();
        response.setResultData(data);
        return response;
    }

    public static BaseResponse error(String desc) {
        BaseResponse response = new BaseResponse();
        response.setResultCode("1");
        response.setResultDesc(desc);
        return response;
    }
    public static BaseResponse error(CMSExceptionCode cmsExceptionCode) {
        BaseResponse response = new BaseResponse();
        response.setResultCode(cmsExceptionCode.getCode());
        response.setResultDesc(cmsExceptionCode.getMessage());
        return response;
    }

    public static BaseResponse parameter(String code,String desc) {
        BaseResponse response = new BaseResponse();
        response.setResultCode(code);
        response.setResultDesc(desc);
        return response;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
    
    
}

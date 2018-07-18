package com.example.jedis.response;

import com.alibaba.fastjson.JSON;
import com.example.jedis.contans.BaseRespCode;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/12
 */
@Data
public class ResultClient<T> implements Serializable{
    private String resultCode;
    private String resultDesc;
    private T resultData;


    public ResultClient() {
    }

    public ResultClient(String resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.resultData = (T) "";
    }

    public ResultClient(T resultData) {
        this.resultCode = BaseRespCode.SUCCESS.getCode();
        this.resultDesc = BaseRespCode.SUCCESS.getMsg();
        this.resultData = resultData;
    }

    public static ResultClient ok() {
        ResultClient response = new ResultClient();
        response.setResultCode( BaseRespCode.SUCCESS.getCode());
        response.setResultDesc(BaseRespCode.SUCCESS.getMsg());
        return response;
    }

    public static ResultClient ok(Object data) {
        ResultClient response = ok();
        response.setResultData(data);
        return response;
    }

    public static ResultClient error() {
        ResultClient response = new ResultClient();
        response.setResultCode(BaseRespCode.FAIL.getCode());
        response.setResultDesc(BaseRespCode.FAIL.getMsg());
        return response;
    }

    public static ResultClient error(String resultCode, String resultDesc) {
        ResultClient response = new ResultClient();
        response.setResultCode( resultCode );
        response.setResultDesc( resultDesc );
        return response;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}

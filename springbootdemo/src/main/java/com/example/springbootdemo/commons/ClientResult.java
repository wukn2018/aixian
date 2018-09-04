 package com.example.springbootdemo.commons;

 import com.alibaba.fastjson.JSON;
 import com.example.springbootdemo.commons.constants.CMSExceptionCode;

 import java.io.Serializable;

 public class ClientResult<T> implements Serializable{

    private String resultCode;
    private String resultDesc;
    private T resultData;

     public ClientResult() {
     }

     public ClientResult(String resultCode, String resultDesc) {
    	this.resultCode = resultCode;
    	this.resultDesc = resultDesc;
    	this.resultData = (T) "";
    }

    public ClientResult(T resultData) {
        this.resultCode = CMSExceptionCode.SUCCESS.getCode();
        this.resultDesc = CMSExceptionCode.SUCCESS.getMessage();
        this.resultData = resultData;
    }

     public static ClientResult ok() {
         ClientResult response = new ClientResult();
         response.setResultCode(CMSExceptionCode.SUCCESS.getCode());
         response.setResultDesc(CMSExceptionCode.SUCCESS.getMessage());
         return response;
     }

     public static ClientResult ok(Object data) {
         ClientResult response = ok();
         response.setResultData(data);
         return response;
     }


     public static ClientResult error(String desc) {
         ClientResult response = new ClientResult();
         response.setResultCode(CMSExceptionCode.FAIL.getCode());
         response.setResultDesc(desc);
         return response;
     }


     public static ClientResult error(CMSExceptionCode cmsExceptionCode) {
         ClientResult response = new ClientResult();
         response.setResultCode(cmsExceptionCode.getCode());
         response.setResultDesc(cmsExceptionCode.getMessage());
         return response;
     }

     public static ClientResult filter(CMSExceptionCode cmsExceptionCode) {
         ClientResult response = new ClientResult();
         response.setResultCode(cmsExceptionCode.getCode());
         response.setResultDesc(cmsExceptionCode.getMessage());

         return response;
     }


    public String getResultCode() {
        return resultCode;
    }
    public String getResultDesc() {
        return resultDesc;
    }
    public T getResultData() {
        return resultData;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

     @Override
     public String toString() {
         return JSON.toJSONString( this );
     }

}

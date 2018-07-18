package com.example.jedis.exception;

import com.example.jedis.contans.BaseRespCode;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/13
 */
public class CMSException extends BaseException{
    public CMSException(BaseRespCode respCode) {
        super(respCode.getCode(),respCode.getMsg());
    }
}

package com.example.jedis.contans;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/12
 */
public enum  BaseRespCode {

    SUCCESS("0", "操作成功"),
    FAIL("1", "操作失败"),
    PARAMS_FORMART_ERROR("2", "请求参数 格式错误"),
    PARAMS_VALUE_ERROR("3", "请求参数 值不合法"),
    SYSTEM_ERROR("4", "系统异常"),
    INADEQUATE_PERMISSION("5", "权限不足");

    BaseRespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}

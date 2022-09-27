package com.atguigu.common.exception;

public enum BizCodeEnume {

    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式效验失败");

    private Integer code;
    private String message;

    BizCodeEnume(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

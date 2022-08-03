package com.huawei.seckill.common.exception;

import java.io.Serializable;

public class RrException extends RuntimeException implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer code = 500;
    private String msg;

    public RrException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RrException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public RrException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }
    public RrException(String msg, Integer code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

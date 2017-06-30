package com.xieyunhai.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author noobit
 * @date 17-6-29 下午9:30
 */
/* todo json 序列化 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HttpResult<T> implements Serializable {

    /* 错误码 */
    private int code;
    /* 提示信息 */
    private String msg;
    /* 具体内容 */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

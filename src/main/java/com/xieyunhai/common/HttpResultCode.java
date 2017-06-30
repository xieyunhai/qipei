package com.xieyunhai.common;

/**
 * @author noobit
 * @date 17-6-29 下午9:37
 */
public enum HttpResultCode {
    UN_KNOW(-1, "未知错误"),
    SUCCESS(0, "success"),
    NOT_FOUND(404, "没有找到"),
    ERROR(1, "权限不足"),
    NEED_LOGIN(10, "需要登录"),
    SERVER_ERROR(500, "服务器错误");


    private final int code;
    private final String desc;

    HttpResultCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

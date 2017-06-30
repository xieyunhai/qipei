package com.xieyunhai.common;

/**
 * @author noobit
 * @date 17-6-29 下午9:37
 */
public enum HttpResultCode {
    UN_KNOW(-1, "未知错误"),

    SUCCESS(0, "success"),
    SUCCESS_ADD(10, "添加成功"),
    SUCCESS_UPDATE(20, "更新成功"),
    SUCCESS_SAVE(30, "保存成功"),
    SUCCESS_DELETE(40, "删除成功"),

    FAIL(400, "fail"),
    FAIL_ADD(410, "添加失败"),
    FAIL_UPDATE(420, "更新失败"),
    FAIL_SAVE(430, "保存失败"),
    FAIL_DELETE(440, "删除失败"),

    NOT_FOUND(404, "没有找到"),
    ERROR(1, "权限不足"),
    NEED_LOGIN(100, "需要登录"),
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

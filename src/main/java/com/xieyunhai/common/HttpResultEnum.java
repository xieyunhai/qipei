package com.xieyunhai.common;

/**
 * @author noobit
 * @date 17-6-29 下午9:37
 */
public enum HttpResultEnum {
    UN_KNOW(-1, "未知错误"),

    SUCCESS(0, "成功"),
    SUCCESS_ADD(10, "添加成功"),
    SUCCESS_UPDATE(20, "更新成功"),
    SUCCESS_SAVE(30, "保存成功"),
    SUCCESS_DELETE(40, "删除成功"),

    NEED_LOGIN(100, "需要登录"),
    ERROR_LOGIN(101, "用户名或者密码错误"),
    SUCCESS_LOGIN(102, "登录成功"),

    ERROR_REGISTER(103, "注册失败"),
    SUCCESS_REGISTER(104, "注册成功"),

    PERMISSION_DENIED(110, "权限不足"),
    ERROR_FIELD(120, "字段错误"),



    ERROR(400, "失败"),
    ERROR_ADD(410, "添加失败"),
    ERROR_UPDATE(420, "更新失败"),
    ERROR_SAVE(430, "保存失败"),
    ERROR_DELETE(440, "删除失败"),

    NOT_FOUND(404, "没有找到"),
    SERVER_ERROR(500, "服务器错误"),

    ERROR_DATABASE(600, "数据库错误"),

    NOT_EXIST(700, "不存在"),
    EXIST(710, "已存在");


    private final int code;
    private final String desc;

    HttpResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "HttpResultEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}

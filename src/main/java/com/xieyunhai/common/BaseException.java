package com.xieyunhai.common;

/**
 * @author admin
 * @since 2017/7/4 15:07
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(HttpResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

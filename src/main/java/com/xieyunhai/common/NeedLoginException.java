package com.xieyunhai.common;

/**
 * Created by noobit on 17-7-5.
 */
public class NeedLoginException extends BaseException {
    public NeedLoginException(HttpResultEnum resultEnum) {
        super(resultEnum);
    }
}

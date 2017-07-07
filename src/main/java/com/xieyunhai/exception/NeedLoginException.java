package com.xieyunhai.exception;

import com.xieyunhai.common.HttpResultEnum;
import com.xieyunhai.exception.BaseException;

/**
 * Created by noobit on 17-7-5.
 */
public class NeedLoginException extends BaseException {
    public NeedLoginException(HttpResultEnum resultEnum) {
        super(resultEnum);
    }
}

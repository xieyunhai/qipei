package com.xieyunhai.exception;

import com.xieyunhai.common.HttpResultEnum;

/**
 * @author admin
 * @since 2017/7/6 9:41
 */
public class PermissionDeniedException extends BaseException {
    public PermissionDeniedException(HttpResultEnum resultEnum) {
        super(resultEnum);
    }
}

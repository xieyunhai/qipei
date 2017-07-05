package com.xieyunhai.util;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author noobit
 * @date 17-6-29 下午9:10
 */
public class HttpResultUtil {

    /**
     * 请求成功, 无数据返回
     * @return success: code, msg
     */
    public static <O> HttpResult<O> success() {
        return success(null);
    }

    /**
     * 请求成功, 返回数据
     * @param object 请求成功的数据
     * @return success: code, msg, data
     */
    public static <O> HttpResult<O> success(O object) {
        HttpResult<O> httpResult = new HttpResult<>();
        httpResult.setSuccess(true);
        httpResult.setCode(HttpResultEnum.SUCCESS.getCode());
        httpResult.setMsg(HttpResultEnum.SUCCESS.getDesc());
        httpResult.setData(object);
        return httpResult;
    }

    /**
     * 请求失败, 返回自定义 code 和自定义 msg
     * @param errorCode 自定义 code
     * @param errorMsg 自定义 msg
     * @return fail: code, msg
     */
    public static <O> HttpResult<O> error(int errorCode, String errorMsg) {
        HttpResult<O> httpResult = new HttpResult<>();
        httpResult.setSuccess(false);
        httpResult.setCode(errorCode);
        httpResult.setMsg(errorMsg);
        return httpResult;
    }

    /**
     * 请求失败, 返回枚举 code
     * @param errorCode 枚举包含的 code
     * @return fail: code, msg
     */
    public static <O> HttpResult<O> error(Integer errorCode) {
        HttpResultEnum resultEnum = Arrays.stream(HttpResultEnum.values())
                .filter(httpResultEnum -> httpResultEnum.getCode() == errorCode)
                .findFirst()
                .orElse(HttpResultEnum.UN_KNOW);
        return error(resultEnum.getCode(), resultEnum.getDesc());
    }

    /**
     * 请求失败, 返回未知错误
     * @return fail: code, msg
     */
    public static <O> HttpResult<O> error() {
        return error(HttpResultEnum.UN_KNOW.getCode(), HttpResultEnum.UN_KNOW.getDesc());
    }
}

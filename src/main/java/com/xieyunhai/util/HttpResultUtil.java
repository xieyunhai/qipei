package com.xieyunhai.util;

import com.xieyunhai.common.HttpResult;
import com.xieyunhai.common.HttpResultEnum;

/**
 * @author noobit
 * @date 17-6-29 下午9:10
 */
public class HttpResultUtil {

    /**
     * 请求成功, 无数据返回
     * @return success: code - 0, msg - "成功", data - null
     */
    public static <O> HttpResult<O> success() {
        return success(null, HttpResultEnum.SUCCESS.getCode(), HttpResultEnum.SUCCESS.getDesc());
    }

    /**
     * 请求成功, 返回数据
     * @param object 请求成功的数据
     * @return success: code - 0, msg - "成功", data - object
     */
    public static <O> HttpResult<O> success(O object) {
        return success(object, HttpResultEnum.SUCCESS.getCode(), HttpResultEnum.SUCCESS.getDesc());
    }

    /**
     * 请求成功, 无数据返回,
     * @param resultEnum 请求结果的枚举 code
     * @param <O> 结果的泛型
     * @return success: code - HttpResultEnum.code, msg - HttpResult.msg
     */
    public static <O> HttpResult<O> success(HttpResultEnum resultEnum) {
        return success(null, resultEnum.getCode(), resultEnum.getDesc());
    }

    /**
     * 请求成功, 返回数据, 类型 O
     * @param <O> object 的泛型
     * @param object object
     * @param resultEnum code
     * @return success: code - HttpResultEnum.code, msg - HttpResult.msg, data - O
     */
    public static <O> HttpResult<O> success(O object, HttpResultEnum resultEnum) {
        return success(object, resultEnum.getCode(), resultEnum.getDesc());
    }

    /**
     * 请求成功, 返回数据, 类型 O
     * @param object object
     * @param code code
     * @param msg msg
     * @param <O> object 的泛型
     * @return success: code - code, msg - msg, data - O
     */
    private static  <O> HttpResult<O> success(O object, Integer code, String msg) {
        HttpResult<O> httpResult = new HttpResult<>();
        httpResult.setSuccess(true);
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        httpResult.setData(object);
        return httpResult;
    }

    /**
     * 请求失败, 返回自定义 code 和自定义 msg
     * @param code 自定义 code
     * @param msg 自定义 msg
     * @return fail: code, msg
     */
    public static <O> HttpResult<O> error(Integer code, String msg) {
        HttpResult<O> httpResult = new HttpResult<>();
        httpResult.setSuccess(false);
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }

    /**
     * 请求失败, 返回枚举 code
     * @param resultEnum 枚举包含的 code
     * @return fail: code, msg
     */
    public static <O> HttpResult<O> error(HttpResultEnum resultEnum) {
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

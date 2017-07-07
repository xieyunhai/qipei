package com.xieyunhai.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @since 2017/7/6 11:39
 */
public class ParamsUtil {
    public static Map<String, Object> getParams(String[] keys, Object[] values) {
        // todo 改为 stream 操作
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            result.put(keys[i], values[i]);
        }
        return result;
    }
}

package com.xieyunhai.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.stream.Stream;

/**
 * @author admin
 * @since 2017/7/4 8:55
 */
public class MD5Util {

    /**
     * 字节数组转化为 16 进制字符串
     * @param bytes 字节数组
     * @return 16 进制字符串
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(byteToHexString(b));
        }
//        Stream.of(bytes).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    /**
     * 字节转换为数字或字符
     * @param b 字节
     * @return 数字或字符
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 通过 MD5 加密
     * @param origin 原字符串
     * @param charsetName 编码格式
     * @return MD5 加密后的字符串
     */
    private static String MD5Encode(String origin, String charsetName) {
        String result = origin;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (StringUtils.isEmpty(charsetName)) {
                result = byteArrayToHexString(messageDigest.digest(result.getBytes()));
            } else {
                result = byteArrayToHexString(messageDigest.digest(result.getBytes(charsetName)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toUpperCase();
    }

    /**
     * MD5 加密对外调用接口
     * @param origin 原字符串
     * @return 加密后字符串
     */
    public static String MD5EncodeUtf8(String origin) {
        return MD5Encode(origin, "utf-8");
    }

    // 全局 16 进制数组
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};
}

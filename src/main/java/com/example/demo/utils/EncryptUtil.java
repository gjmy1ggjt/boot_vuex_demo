package com.example.demo.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;

// 加密帮助类
public class EncryptUtil {

//    加密的key 必须为16个长度的byte[], 字母1个字符串就是一个byte长度
    private static byte[] key = "abcdabcdabcdabcd".getBytes();

    // 加密为16进制表示
    public static String encryptHex(String content) {

        return SecureUtil.aes(key).encryptHex(content);
    }

    // 解密为字符串
    public static String decryptStr(String encryptHex) {
        return SecureUtil.aes(key).decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

    }

}

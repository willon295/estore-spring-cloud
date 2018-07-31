package com.briup.estore.common.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 + Base64 加密工具类
 *
 * @author willon
 * @version 1.0
 * 联系方式： willon295@163.com
 * @since 18-7-30
 */
public class Md5Base64Encoder {

    /**
     * 将原始字符串 采用 MD5 + Base64 加密
     *
     * @param origin 需要加密的字符串
     * @return 加密并且 去处特殊字符 / = 后的字符串
     * @throws NoSuchAlgorithmException 算法不存在
     */
    public static String encode(String origin) throws NoSuchAlgorithmException {

        BASE64Encoder base64Encoder = new BASE64Encoder();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String encode = base64Encoder.encode(md5.digest(origin.getBytes()));
        return encode.replaceAll("[=]", "").replaceAll("/", "");
    }
}

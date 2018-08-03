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

        //混淆
        String base = "$*934AF8d$^7dffD";
        origin += base;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(origin.getBytes());
        byte[] b = md5.digest();
        StringBuilder sb = new StringBuilder();
        int i;
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return base64Encoder.encode(sb.toString().getBytes());
    }


}

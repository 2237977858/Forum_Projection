package com.noself.utils;

import io.netty.util.internal.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.digester.Digester;

public class StringTools {
    public static Boolean isEmpty(String str) {
        if(str == null || str.trim().equals("") || str.equals("null")) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 生成英文数字随机字符串
     * @param count
     * @return
     */
    public static final String getRandomString(Integer count) {
        return RandomStringUtils.random(count, true, true);
    }

    /**
     * 生成纯数字随机字符串
     * @param count
     * @return
     */
    public static final String getRandomNumber(Integer count) {
        return RandomStringUtils.random(count, false, true);
    }

    /**
     * 将字符串用md5加密
     * @param str
     * @return
     */
    public static String encodeMd5(String str) {
        return StringTools.isEmpty(str) ? null : DigestUtils.md5Hex(str);
    }
}

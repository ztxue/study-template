package com.example.blog.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * 密码工具类
 *
 * @author chenlirun
 * @date 2021/7/8 17:04
 */
public class PasswordUtil {

    /**
     * md5+salt 加密算法 (推荐)
     *
     * @author chenlirun
     * @date 2021/7/8 17:09
     */
    public static String getMD5Encryption(String password) {
        //密码md5+随机盐加密
        return DigestUtils.md5DigestAsHex((password + getSalt()).getBytes(StandardCharsets.UTF_8));
    }
    /**
     * 生成随机盐
     *
     * @author chenlirun
     * @date 2021/7/8 15:56
     */
    public static String getSalt() {
        String str = "zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP1234567890,.<>:?";
        StringBuilder stringBuffer = new StringBuilder();

        //循环16次，共取出16个随机字符
        for (int i = 0; i < 16; i++) {
            //每次生成一个67以内的随机数
            int number = new Random().nextInt(68);
            //生成的随机数作为 str 字符串的下标；从 str 中取出随机字符后追加到 stringBuffer
            stringBuffer.append(str.charAt(number));
        }
        return stringBuffer.toString();
    }
}


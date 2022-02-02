package com.example.demo1210.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * @author: sunping
 * @description: AesUtil
 * @date: 2021/3/31
 */
@Slf4j
public class AesUtil {
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 默认的加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private AesUtil() {}

    /**
     * 随机生成密钥
     *
     */
    public static String getAesRandomKey() {
        SecureRandom random = new SecureRandom();
        long randomKey = random.nextLong();
        return String.valueOf(randomKey);
    }

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key     加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String key) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return byte2Base64(result);
        } catch (Exception ex) {
            log.error("加密失败", ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     */
    public static String decrypt(String content, String key) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            //执行操作
            byte[] result = cipher.doFinal(base642Byte(content));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            log.error("解密失败", ex);
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     */
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        try {
            KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            // 指定算法名称，不同的系统上生成的key是相同的。
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            log.info("生成加密秘钥异常！", ex);
        }
        return null;
    }

    /**
     * 字节数组转Base64编码
     *
     */
    public static String byte2Base64(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    /**
     * Base64编码转字节数组
     *
     */
    public static byte[] base642Byte(String base64Key) {
        Decoder decoder = Base64.getDecoder();
        return decoder.decode(base64Key);
    }

}

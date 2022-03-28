package com.example.blog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Tlimited
 */
@SuppressWarnings("all")
@Component
public class JwtUtil {
    //过期时间 15分钟
    private static final long EXPIRE_TIME = 15 * 60 * 1000L;
    //私钥
    private static final String TOKEN_SECRET = "ZTXUE19990727";

    /**
     * 生成签名，15分钟过期
     * 根据内部改造，支持6中类型，Integer,Long,Boolean,Double,String,Date
     */
    public static String sign(Map<String, Object> map) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "jwt");
            // 返回token字符串
            JWTCreator.Builder builder = JWT.create()
                    .withHeader(header)
                    //发证时间
                    .withIssuedAt(new Date())
                    //过期时间
                    .withExpiresAt(date);
            map.forEach((key, value) -> {
                if (value instanceof Integer) {
                    builder.withClaim(key, (Integer) value);
                } else if (value instanceof Long) {
                    builder.withClaim(key, (Long) value);
                } else if (value instanceof Boolean) {

                    builder.withClaim(key, (Boolean) value);
                } else if (value instanceof String) {
                    builder.withClaim(key, String.valueOf(value));
                } else if (value instanceof Double) {
                    builder.withClaim(key, (Double) value);
                } else if (value instanceof Date) {
                    builder.withClaim(key, (Date) value);
                }
            });
            return builder.sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 检验token是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户自定义Claim集合
     */
    public static Map<String, Claim> getClaims(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token).getClaims();
    }

    /**
     * 获取过期时间
     */
    public static Date getExpiresAt(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        return JWT.require(algorithm).build().verify(token).getExpiresAt();
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        return JWT.require(algorithm).build().verify(token).getIssuedAt();
    }

    /**
     * 验证token是否失效
     */
    public static boolean isExpired(String token) {
        try {
            final Date expiration = getExpiresAt(token);
            return expiration.before(new Date());
        } catch (TokenExpiredException e) {
            return true;
        }

    }

    /**
     * 直接Base64解密获取header内容
     */
    public static String getHeaderByBase64(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        } else {
            byte[] headerByte = Base64.getDecoder().decode(token.split("\\.")[0]);
            return new String(headerByte);
        }

    }

    /**
     * 直接Base64解密获取payload内容
     */
    public static String getPayloadByBase64(String token) {

        if (StringUtils.isEmpty(token)) {
            return null;
        } else {
            byte[] payloadByte = Base64.getDecoder().decode(token.split("\\.")[1]);
            return new String(payloadByte);
        }

    }

    /**
     * 刷新token
     */
    public static String refreshToken(Map<String, Object> map) {

        return JwtUtil.sign(map);
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "123456");
        map.put("rose", "admin");
        map.put("integer", 1111);
        map.put("double", 112.222);
        map.put("Long", 112L);
        map.put("bool", true);
        map.put("date", new Date());
        String token = sign(map); //生成token

        System.out.println(verify(token));//验证token是否正确
        String dd = getClaims(token).get("userId").asString(); //使用方法
        System.out.println(dd);
        System.out.println("获取签发token时间：" + getIssuedAt(token));
        System.out.println("获取过期时间：" + getExpiresAt(token));
        // Thread.sleep(1000*40);
        System.out.println("检查是否已过期：" + isExpired(token));
        System.out.println("获取头" + getHeaderByBase64(token));
        System.out.println("获取负荷" + getPayloadByBase64(token));
    }

}



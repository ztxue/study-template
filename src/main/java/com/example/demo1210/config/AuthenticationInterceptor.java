package com.example.demo1210.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo1210.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * 拦截器去获取token并验证token
 * 默认所有接口都需要认证
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 获取请求头中的令牌
        String token = request.getHeader("token");
        try {
            // 验证令牌
            JwtUtil.verify(token);
            // 放行请求
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名！");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token 过期！");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "token 算法不一致！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "无效的 token！");
        }
        // 设置状态
        map.put("state", false);
        // 将 map 转为 json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}

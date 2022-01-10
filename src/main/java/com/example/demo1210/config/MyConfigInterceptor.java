package com.example.demo1210.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/10 14:26
 * @describe
 */
@SuppressWarnings("all")
public class MyConfigInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用
     * 只有返回true，才会继续执行后续的Interceptor和Controller
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器1");
        return true;
    }

    /**
     * 在当前请求进行处理之后，也就是Controller方法调用之后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了拦截器2");
    }
    /**
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了拦截器3");
    }
}

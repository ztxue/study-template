package com.example.demo1210.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author 张童学
 * @version 1.0
 * describe 全局日志管理
 * @date 2021/12/13 10:30
 */
@Component
@Aspect
@Slf4j
public class LogAop {

    //    @Pointcut("execution(* com.example.com.controller.*.*(..))")
    @Pointcut("@annotation(com.example.demo1210.config.LogAnnotation)")
    public void pt() {
        // 没有为什么
    }

    //环绕通知
    @Around("pt()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行
        Object result = proceedingJoinPoint.proceed();
        long sumTime = System.currentTimeMillis() - beginTime;

        recordLog(proceedingJoinPoint, sumTime);
        return result;
    }

    public void recordLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("title:{}", logAnnotation.title());
        log.info("tag:{}", logAnnotation.tag());

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("请求的方法是:{}", className + "." + methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0;i<args.length;i++){
            String params = JSON.toJSONString(args[i]);
            log.info("请求的参数是:{}", params);
        }
        log.info("执行时间:{}", time + "ms");
    }

    /*** @Before 在目标方法之前切入；切入点表达式（指定在哪个方法切入） */
    @Before("pt()")
    public void logStart(JoinPoint joinPoint) {
        log.info("=========================log start============================");
    }

    @After("pt()")
    public void logEnd(JoinPoint joinPoint) {
        log.info("=========================log end============================");
    }

    /***JoinPoint一定要出现在参数表的第一位*/
    @AfterReturning(value = "pt()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("=========================方法执行结束后运行============================");
    }

    @AfterThrowing(value = "pt()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        log.info("=========================有异常============================");
    }
}

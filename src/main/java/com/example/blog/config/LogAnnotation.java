package com.example.blog.config;

import java.lang.annotation.*;

/**
 * @author 张童学
 * @version 1.0
 * describe 日志注解
 * @date 2021/12/13 11:12
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LogAnnotation {

    /**
     * 标题
     */
    String title() default "";

    /**
     * 标签
     */
    String tag() default "";
}

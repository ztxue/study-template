package com.example.blog.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前端 数据封闭类
 *
 * @author ztxue
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    /**
     * 返回码
     */
    @JSONField(ordinal = 10)
    private String code;
    /**
     * 提示信息
     */
    @JSONField(ordinal = 20)
    private String msg;
    /**
     * 业务数据
     */
    @JSONField(ordinal = 30)
    private T data;

    /**
     * 成功不返回数据
     */
    public static <T> R<T> success() {
        return new R<>(ResultEnum.SUCCESS200.getCode(), ResultEnum.SUCCESS200.getDesc(), null);
    }

    /**
     * 成功
     */
    public static <T> R<T> success(T data) {
        return new R<>(ResultEnum.SUCCESS200.getCode(), ResultEnum.SUCCESS200.getDesc(), data);
    }

    /**
     * 成功-自定义返回语句
     */
    public static <T> R<T> success(String msg) {
        return new R<>(ResultEnum.SUCCESS200.getCode(), msg, null);
    }

    /**
     * 失败
     */
    public static <T> R<T> fail() {
        return new R<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getDesc(), null);
    }

    /**
     * 失败返回数据
     */
    public static <T> R<T> fail(T data) {
        return new R<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getDesc(), data);
    }

    /**
     * 失败返回自定义信息
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(ResultEnum.FAIL.getCode(), msg, null);
    }

    /**
     * 参数解析失败
     */
    public static <T> R<T> fail400() {
        return new R<>(ResultEnum.FAIL400.getCode(), ResultEnum.FAIL400.getDesc(), null);
    }

    /**
     * 身份信息已失效
     */
    public static <T> R<T> fail401() {
        return new R<>(ResultEnum.FAIL401.getCode(), ResultEnum.FAIL401.getDesc(), null);
    }

    /**
     * 无权限
     */
    public static <T> R<T> fail403() {
        return new R<>(ResultEnum.FAIL403.getCode(), ResultEnum.FAIL403.getDesc(), null);
    }

    /**
     * 请求地址不存在
     */
    public static <T> R<T> fail404() {
        return new R<>(ResultEnum.FAIL404.getCode(), ResultEnum.FAIL404.getDesc(), null);
    }

    /**
     * 不支持当前请求方法
     */
    public static <T> R<T> fail405() {
        return new R<>(ResultEnum.FAIL405.getCode(), ResultEnum.FAIL405.getDesc(), null);
    }

    /**
     * 程序异常
     */
    public static <T> R<T> fail500() {
        return new R<>(ResultEnum.FAIL500.getCode(), ResultEnum.FAIL500.getDesc(), null);
    }

    /**
     * 数据库操作异常
     */
    public static <T> R<T> fail501() {
        return new R<>(ResultEnum.FAIL501.getCode(), ResultEnum.FAIL501.getDesc(), null);
    }

    /**
     * 服务器繁忙
     */
    public static <T> R<T> fail503() {
        return new R<>(ResultEnum.FAIL503.getCode(), ResultEnum.FAIL503.getDesc(), null);
    }

    /**
     * ID为空
     */
    public static <T> R<T> idNull() {
        return new R<>(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc(), null);
    }

    /**
     * 空参
     */
    public static <T> R<T> argsNull() {
        return new R<>(ResultEnum.ARGSNULL.getCode(), ResultEnum.ARGSNULL.getDesc(), null);
    }

}

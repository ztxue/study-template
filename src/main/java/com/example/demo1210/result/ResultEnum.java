package com.example.demo1210.result;

/**
 * 常量类
 */
public enum ResultEnum {

    /**
     * 操作成功
     */
    SUCCESS200("200", "操作成功"),
    /**
     * 操作失败
     */
    FAIL("000", "操作失败"),
    /**
     * 参数解析失败
     */
    FAIL400("400", "参数解析失败"),
    /**
     * 身份信息已失效
     */
    FAIL401("401", "已失效"),
    /**
     * 无权限
     */
    FAIL403("403", "无权限"),
    /**
     * 请求地址不存在
     */
    FAIL404("404", "请求地址不存在"),
    /**
     * 不支持当前请求方法
     */
    FAIL405("405", "不支持当前请求方法"),
    /**
     * 程序异常
     */
    FAIL500("500", "程序异常"),
    /**
     * 数据库操作异常
     */
    FAIL501("501", "数据库操作异常"),
    /**
     * 服务器繁忙
     */
    FAIL503("503", "服务器繁忙"),
    /**
     * ID为空
     */
    IDNULL("500", "ID为空"),

    /**
     * 空参
     */
    ARGSNULL("500","空参");



    private final String code;
    private final String desc;

    ResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

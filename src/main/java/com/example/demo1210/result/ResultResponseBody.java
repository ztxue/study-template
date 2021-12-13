package com.example.demo1210.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * 返回前端 数据封闭类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseBody<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    //不返回数据
    public static ResultResponseBody ok() {
        return new ResultResponseBody(ResultEnum.OK_CODE, ResultEnum.OK_MSG, null);
    }
    //返回数据
    public static ResultResponseBody ok(Object data) {
        return new ResultResponseBody(ResultEnum.OK_CODE, ResultEnum.OK_MSG, data);
    }
    //返回自定义消息和数据
    public static ResultResponseBody ok(String msg, Object data) {
        return new ResultResponseBody(ResultEnum.OK_CODE, msg, data);
    }
    //返回自定义-失败消息
    public static ResultResponseBody fail(String msg) {
        return new ResultResponseBody(ResultEnum.FAIL_CODE, msg, null);
    }
    //返回自定义-code和失败消息
    public static ResultResponseBody fail(int errorCode, String msg) {
        return new ResultResponseBody(errorCode, msg, null);
    }

}

package com.example.demo1210.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: sunping
 * @description: 成功状态返回
 * @date: 2020/11/02
 */
@Setter
@Getter
public class ResultSuccess<T> {

    public ResultSuccess() {
    }

    public ResultSuccess(T success) {
        this.success = success;
    }

    /**
     * 列表
     */
    private T success;
}

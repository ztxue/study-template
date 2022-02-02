package com.example.demo1210.result;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author: sunping
 * @description: 删除请求实体对象
 * @date: 2020/7/25
 */
@Setter
@Getter
public class DeleteParams<T> {
    /**
     * id数组
     */
    private Set<T> ids;
}

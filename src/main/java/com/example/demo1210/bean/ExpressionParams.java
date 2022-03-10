package com.example.demo1210.bean;
import lombok.Getter;
import lombok.Setter;


/**
 * @author: 张童学
 * @description:  参数类
 * @date: 2022-02-19
 */

@Getter
@Setter
public class ExpressionParams {
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}

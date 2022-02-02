package com.example.demo1210.bean;
import lombok.Data;


/**
 * @author: 张童学
 * @description: 区划信息 参数类
 * @date: 2022-01-26
 */

@Data
public class SysAreaParams {
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}

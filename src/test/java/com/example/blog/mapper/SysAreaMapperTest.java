package com.example.blog.mapper;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/27 15:05
 * @describe
 */
class SysAreaMapperTest {

    @Resource
    SysAreaMapper mapper;

    @Test
    void selectSymptomTreeNodeJson() {
        System.out.println(mapper.getTree());
    }
}

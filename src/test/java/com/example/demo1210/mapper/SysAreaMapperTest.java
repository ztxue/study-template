package com.example.demo1210.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

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

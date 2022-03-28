package com.example.blog.controller;

import com.example.blog.mapper.SysAreaMapper;
import com.example.blog.service.impl.SysAreaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/27 14:50
 * @describe
 */
class SysAreaControllerTest {

    SysAreaServiceImpl service;
    @Autowired
    SysAreaMapper mapper;

    public SysAreaControllerTest(SysAreaServiceImpl service) {
        this.service = service;
    }

    @Test
    void tree() {
        System.out.println(service.getTree());
    }
}

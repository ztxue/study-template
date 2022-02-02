package com.example.demo1210.controller;

import com.example.demo1210.mapper.SysAreaMapper;
import com.example.demo1210.service.impl.SysAreaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

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

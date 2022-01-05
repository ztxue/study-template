package com.example.demo1210.controller;

import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.entity.DPojo;
import com.example.demo1210.result.ResultResponseBody;
import com.example.demo1210.service.impl.DPojoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/5 13:47
 * @describe
 */
@RestController
@RequestMapping("/")
public class DPojoController {

    @Autowired
    DPojoServiceImpl service;

    @GetMapping("/listTree")
    public ResultResponseBody<List<DPojo>> listResultResponseBody(int id){
        return ResultResponseBody.success(service.getAllOneTwoSubject(id));
    }

    @GetMapping("/listTree2")
    public ResultResponseBody<List<TreeNode>> listResultResponseBody() {
        return ResultResponseBody.success(service.getTree());
    }
}

package com.example.demo1210.controller;

import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.entity.DPojo;
import com.example.demo1210.result.R;
import com.example.demo1210.service.impl.DPojoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
@RequestMapping("/")
public class DPojoController {

    @Autowired
    DPojoServiceImpl service;

    /**
     * 递归树状
     */
    @GetMapping("/listTree")
    public R<List<DPojo>> listResultResponseBody(Integer id){
        return R.success(service.getAllOneTwoSubject());
    }
    /**
     * 工具类
     */
    @GetMapping("/listTree2")
    public R<List<TreeNode>> listResultResponseBody() {
        return R.success(service.getTree());
    }
}

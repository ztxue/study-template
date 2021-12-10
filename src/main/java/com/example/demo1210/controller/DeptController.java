package com.example.demo1210.controller;


import com.example.demo1210.entity.Dept;
import com.example.demo1210.service.impl.DeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */

@Api
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptServiceImpl deptService;

    public DeptController(DeptServiceImpl deptService) {
        this.deptService = deptService;
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public List<Dept> getList(){
        return deptService.deptList();
    }

    @ApiOperation("id")
    @GetMapping("/id")
    public Dept getOneById(@RequestParam(value = "id")int id){
        return deptService.getById(id);
    }
}

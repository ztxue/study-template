package com.example.demo1210.controller;


import com.example.demo1210.entity.Dept;
import com.example.demo1210.result.ResultResponseBody;
import com.example.demo1210.service.impl.DeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Slf4j
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
    public ResultResponseBody<List<Dept>> getList() {
        return ResultResponseBody.ok(deptService.deptList());
    }

    @ApiOperation("id")
    @GetMapping("/id")
    public ResultResponseBody<Dept> getOneById(@RequestParam(value = "id") int id) {
        Dept dept = deptService.getById(id);
        return ResultResponseBody.ok(dept);
    }

    @ApiOperation("Did")
    @PostMapping("/Did")
    public ResultResponseBody<Dept> selectCountByDId(@RequestParam(value = "ids") Set<Integer> ids) {
        return ResultResponseBody.ok(deptService.selectCountByOrgId(ids));
    }
}

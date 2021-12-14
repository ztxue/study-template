package com.example.demo1210.controller;


import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.config.LogAnnotation;
import com.example.demo1210.entity.Dept;
import com.example.demo1210.result.ResultResponseBody;
import com.example.demo1210.service.impl.DeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.pool.TypePool;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
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


@Api
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptServiceImpl deptService;

    public DeptController(DeptServiceImpl deptService) {
        this.deptService = deptService;
    }

    @LogAnnotation(title = "列表", tag = "获取列表")
    @ApiOperation("列表")
    @GetMapping("/list")
    public ResultResponseBody<List<Dept>> getList() {

        return ResultResponseBody.ok(deptService.deptList());
    }

    @Cacheable(key = "#id", cacheNames = "id", condition = "#id>3")
    @LogAnnotation(title = "根据", tag = "id")
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

    @ApiOperation("deleByName")
    @DeleteMapping("/dele")
    public ResultResponseBody<Dept> dele(@RequestParam(value = "dele") String name) {
        return ResultResponseBody.ok("删除ok", deptService.deleteByName(name));
    }

    @ApiOperation("up")
    @PutMapping("/up")
    public ResultResponseBody<Dept> upde(@RequestParam(value = "tel") String tel) {
        return ResultResponseBody.ok("ok", deptService.updateTelByName(tel));
    }

    @LogAnnotation(title = "增加一个部门", tag = "增加")
    @ApiOperation("增加")
    @PostMapping("/add")
    public ResultResponseBody<Dept> add(@RequestBody DeptBean deptBean) {

        return ResultResponseBody.ok(deptService.addDept(deptBean));
    }

}

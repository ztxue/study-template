package com.example.demo1210.controller;

import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.result.R;
import com.example.demo1210.result.ResultList;
import com.example.demo1210.result.ResultSuccess;
import com.example.demo1210.result.DeleteParams;

import com.example.demo1210.entity.SysArea;
import com.example.demo1210.bean.SysAreaParams;

import com.example.demo1210.service.impl.SysAreaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张童学
 * @description: 区划信息 Controller
 * @date: 2022-01-26
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/sys/area")
public class SysAreaController {

    private final SysAreaServiceImpl sysAreaServiceImpl;

    public SysAreaController(SysAreaServiceImpl sysAreaServiceImpl) {
        this.sysAreaServiceImpl = sysAreaServiceImpl;
    }

    /**
     * 工具类
     */
    @GetMapping("/tree")
    public R<List<TreeNode>> listResultResponseBody() {
        return R.success(sysAreaServiceImpl.getTree());
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultList<SysArea>> list(@RequestBody SysAreaParams params) {
        if (params == null) {
            return R.fail400();
        }
        ResultList<SysArea> list = sysAreaServiceImpl.list(params);
        return R.success(list);
    }

    /**
     * 添加
     */
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> add(@RequestBody SysArea entity) {
        if (entity == null) {
            return R.fail400();
        }
        Integer success = sysAreaServiceImpl.add(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 修改
     */
    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> update(@RequestBody SysArea entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            return R.fail500();
        }
        Integer success = sysAreaServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 详情
     */
    @GetMapping(value = "show", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<SysArea> show(Integer id) {
        if (id == null) {
            return R.fail500();
        }
        SysArea entity = sysAreaServiceImpl.show(id);
        return R.success(entity);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> delete(@RequestBody DeleteParams<Integer> deleteParams) {
        if (deleteParams == null) {
            return R.fail400();
        }
        if (deleteParams.getIds() == null || deleteParams.getIds().isEmpty()) {
            return R.fail500();
        }
        Integer success = sysAreaServiceImpl.delete(deleteParams.getIds());
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

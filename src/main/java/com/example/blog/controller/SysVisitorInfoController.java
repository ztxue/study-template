package com.example.blog.controller;

import com.example.blog.result.R;
import com.example.blog.result.ResultList;
import com.example.blog.result.ResultSuccess;
import com.example.blog.result.DeleteParams;

import com.example.blog.entity.SysVisitorInfo;
import com.example.blog.bean.SysVisitorInfoParams;
import com.example.blog.service.ISysVisitorInfoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张童学
 * @description: 游客表 Controller
 * @date: 2022-03-25
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/sys/visitor/info")
public class SysVisitorInfoController {

    private final ISysVisitorInfoService sysVisitorInfoServiceImpl;

    public SysVisitorInfoController(ISysVisitorInfoService sysVisitorInfoServiceImpl) {
        this.sysVisitorInfoServiceImpl = sysVisitorInfoServiceImpl;
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultList<SysVisitorInfo>> list(@RequestBody SysVisitorInfoParams params) {
        if (params == null) {
            return R.fail400();
        }
        ResultList<SysVisitorInfo> list = sysVisitorInfoServiceImpl.list(params);
        return R.success(list);
    }

    /**
     * 添加
     */
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> add(@RequestBody SysVisitorInfo entity) {
        if (entity == null) {
            return R.fail400();
        }
        Integer success = sysVisitorInfoServiceImpl.add(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 修改
     */
    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> update(@RequestBody SysVisitorInfo entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            return R.fail500();
        }
        Integer success = sysVisitorInfoServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 详情
     */
    @GetMapping(value = "show", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<SysVisitorInfo> show(Integer id) {
        if (id == null) {
            return R.fail500();
        }
        SysVisitorInfo entity = sysVisitorInfoServiceImpl.show(id);
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
        Integer success = sysVisitorInfoServiceImpl.delete(deleteParams.getIds());
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

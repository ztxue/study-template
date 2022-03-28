package com.example.blog.controller;

import com.example.blog.result.R;
import com.example.blog.result.ResultList;
import com.example.blog.result.ResultSuccess;
import com.example.blog.result.DeleteParams;

import com.example.blog.entity.TbComment;
import com.example.blog.bean.TbCommentParams;
import com.example.blog.service.ITbCommentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张童学
 * @description: 评论表 Controller
 * @date: 2022-03-25
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/tb/comment")
public class TbCommentController {

    private final ITbCommentService tbCommentServiceImpl;

    public TbCommentController(ITbCommentService tbCommentServiceImpl) {
        this.tbCommentServiceImpl = tbCommentServiceImpl;
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultList<TbComment>> list(@RequestBody TbCommentParams params) {
        if (params == null) {
            return R.fail400();
        }
        ResultList<TbComment> list = tbCommentServiceImpl.list(params);
        return R.success(list);
    }

    /**
     * 添加
     */
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> add(@RequestBody TbComment entity) {
        if (entity == null) {
            return R.fail400();
        }
        Integer success = tbCommentServiceImpl.add(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 修改
     */
    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> update(@RequestBody TbComment entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            return R.fail500();
        }
        Integer success = tbCommentServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 详情
     */
    @GetMapping(value = "show", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<TbComment> show(Integer id) {
        if (id == null) {
            return R.fail500();
        }
        TbComment entity = tbCommentServiceImpl.show(id);
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
        Integer success = tbCommentServiceImpl.delete(deleteParams.getIds());
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

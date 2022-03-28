package com.example.blog.controller;

import com.example.blog.result.R;
import com.example.blog.result.ResultList;
import com.example.blog.result.ResultSuccess;
import com.example.blog.result.DeleteParams;

import com.example.blog.entity.TbFriendlink;
import com.example.blog.bean.TbFriendlinkParams;
import com.example.blog.service.ITbFriendlinkService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张童学
 * @description: 友链表 Controller
 * @date: 2022-03-25
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/tb/friendlink")
public class TbFriendlinkController {

    private final ITbFriendlinkService tbFriendlinkServiceImpl;

    public TbFriendlinkController(ITbFriendlinkService tbFriendlinkServiceImpl) {
        this.tbFriendlinkServiceImpl = tbFriendlinkServiceImpl;
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultList<TbFriendlink>> list(@RequestBody TbFriendlinkParams params) {
        if (params == null) {
            return R.fail400();
        }
        ResultList<TbFriendlink> list = tbFriendlinkServiceImpl.list(params);
        return R.success(list);
    }

    /**
     * 添加
     */
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> add(@RequestBody TbFriendlink entity) {
        if (entity == null) {
            return R.fail400();
        }
        Integer success = tbFriendlinkServiceImpl.add(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 修改
     */
    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> update(@RequestBody TbFriendlink entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            return R.fail500();
        }
        Integer success = tbFriendlinkServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 详情
     */
    @GetMapping(value = "show", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<TbFriendlink> show(Integer id) {
        if (id == null) {
            return R.fail500();
        }
        TbFriendlink entity = tbFriendlinkServiceImpl.show(id);
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
        Integer success = tbFriendlinkServiceImpl.delete(deleteParams.getIds());
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

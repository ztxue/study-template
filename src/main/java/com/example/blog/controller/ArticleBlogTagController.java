package com.example.blog.controller;

import com.example.blog.result.R;
import com.example.blog.result.ResultList;
import com.example.blog.result.ResultSuccess;
import com.example.blog.result.DeleteParams;

import com.example.blog.entity.ArticleBlogTag;
import com.example.blog.bean.ArticleBlogTagParams;
import com.example.blog.service.IArticleBlogTagService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张童学
 * @description: 文章标签管理 Controller
 * @date: 2022-03-25
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/article/blog/tag")
public class ArticleBlogTagController {

    private final IArticleBlogTagService articleBlogTagServiceImpl;

    public ArticleBlogTagController(IArticleBlogTagService articleBlogTagServiceImpl) {
        this.articleBlogTagServiceImpl = articleBlogTagServiceImpl;
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultList<ArticleBlogTag>> list(@RequestBody ArticleBlogTagParams params) {
        if (params == null) {
            return R.fail400();
        }
        ResultList<ArticleBlogTag> list = articleBlogTagServiceImpl.list(params);
        return R.success(list);
    }

    /**
     * 添加
     */
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> add(@RequestBody ArticleBlogTag entity) {
        if (entity == null) {
            return R.fail400();
        }
        Integer success = articleBlogTagServiceImpl.add(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 修改
     */
    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> update(@RequestBody ArticleBlogTag entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            return R.fail500();
        }
        Integer success = articleBlogTagServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 详情
     */
    @GetMapping(value = "show", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ArticleBlogTag> show(Integer id) {
        if (id == null) {
            return R.fail500();
        }
        ArticleBlogTag entity = articleBlogTagServiceImpl.show(id);
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
        Integer success = articleBlogTagServiceImpl.delete(deleteParams.getIds());
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

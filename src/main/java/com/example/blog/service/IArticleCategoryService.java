package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.ArticleCategoryParams;
import com.example.blog.entity.ArticleCategory;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 分类表 Service接口
 * @date: 2022-03-25
 */
public interface IArticleCategoryService extends IService<ArticleCategory> {
    /**
     * 查询列表
     */
    ResultList<ArticleCategory> list(ArticleCategoryParams params);
    /**
     * 添加
     */
    int add(ArticleCategory entity);
    /**
     * 修改
     */
    int update(ArticleCategory entity);
    /**
     * 显示
     */
    ArticleCategory show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.ArticleBlogTagParams;
import com.example.blog.entity.ArticleBlogTag;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 文章标签管理 Service接口
 * @date: 2022-03-25
 */
public interface IArticleBlogTagService extends IService<ArticleBlogTag> {
    /**
     * 查询列表
     */
    ResultList<ArticleBlogTag> list(ArticleBlogTagParams params);
    /**
     * 添加
     */
    int add(ArticleBlogTag entity);
    /**
     * 修改
     */
    int update(ArticleBlogTag entity);
    /**
     * 显示
     */
    ArticleBlogTag show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

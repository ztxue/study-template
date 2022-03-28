package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.ArticleTagParams;
import com.example.blog.entity.ArticleTag;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 标签表 Service接口
 * @date: 2022-03-25
 */
public interface IArticleTagService extends IService<ArticleTag> {
    /**
     * 查询列表
     */
    ResultList<ArticleTag> list(ArticleTagParams params);
    /**
     * 添加
     */
    int add(ArticleTag entity);
    /**
     * 修改
     */
    int update(ArticleTag entity);
    /**
     * 显示
     */
    ArticleTag show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

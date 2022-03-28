package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.ArticleInfoParams;
import com.example.blog.entity.ArticleInfo;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 文章表 Service接口
 * @date: 2022-03-25
 */
public interface IArticleInfoService extends IService<ArticleInfo> {
    /**
     * 查询列表
     */
    ResultList<ArticleInfo> list(ArticleInfoParams params);
    /**
     * 添加
     */
    int add(ArticleInfo entity);
    /**
     * 修改
     */
    int update(ArticleInfo entity);
    /**
     * 显示
     */
    ArticleInfo show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.ArticleCategoryParams;
import com.example.blog.entity.ArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 分类表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`name`" +
            " ,t.`create_time`" +
            " ,t.`update_time`" +
            " FROM article_category t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<ArticleCategory> selectListByParams(@Param("params") ArticleCategoryParams params, @Param("page") Page<ArticleCategory> page);
}

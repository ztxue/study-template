package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.ArticleBlogTagParams;
import com.example.blog.entity.ArticleBlogTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 文章标签管理 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface ArticleBlogTagMapper extends BaseMapper<ArticleBlogTag> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`article_id`" +
            " ,t.`tag_id`" +
            " FROM article_blog_tag t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<ArticleBlogTag> selectListByParams(@Param("params") ArticleBlogTagParams params, @Param("page") Page<ArticleBlogTag> page);
}

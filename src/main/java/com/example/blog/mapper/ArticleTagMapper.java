package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.ArticleTagParams;
import com.example.blog.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 标签表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`name`" +
            " ,t.`create_time`" +
            " FROM article_tag t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<ArticleTag> selectListByParams(@Param("params") ArticleTagParams params, @Param("page") Page<ArticleTag> page);
}

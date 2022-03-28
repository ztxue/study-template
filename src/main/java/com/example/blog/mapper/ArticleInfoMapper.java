package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.ArticleInfoParams;
import com.example.blog.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 文章表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`author_id`" +
            " ,t.`category_id`" +
            " ,t.`title`" +
            " ,t.`cover`" +
            " ,t.`content`" +
            " ,t.`create_time`" +
            " ,t.`update_time`" +
            " ,t.`is_top`" +
            " ,t.`is_draft`" +
            " ,t.`id_deleted`" +
            " FROM article_info t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<ArticleInfo> selectListByParams(@Param("params") ArticleInfoParams params, @Param("page") Page<ArticleInfo> page);
}

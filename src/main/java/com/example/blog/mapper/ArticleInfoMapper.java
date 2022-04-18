package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.bean.ArticleInfoParams;
import com.example.blog.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
            ",t.`nick_name`" +
            ",c.`name`" +
            ",t.`author_id`" +
            ",u.`avatar`" +
            ",t.`category_id`" +
            ",t.`title`" +
            ",t.`cover`" +
            ",t.`content`" +
            ",t.`create_time`" +
            ",t.`update_time`" +
            ",t.`is_top`" +
            ",t.`is_draft`" +
            " FROM article_info t,article_category c,sys_user_info u" +
            "<where>" +
            " t.`id_deleted` = 0 " +
            "AND" +
            " t.`category_id` = c.`id`" +
            "AND" +
            " t.`author_id` = u.`id` " +
            "<if test=\"params.title!='' and params.title!=null and params.title!='null'\">" +
            "AND" +
            " (t.`title` like CONCAT('%',#{params.title,jdbcType=VARCHAR},'%') " +
            "OR" +
            " t.`content` like CONCAT('%',#{params.title,jdbcType=VARCHAR},'%')" +
            "OR" +
            " t.`nick_name` like CONCAT('%',#{params.title,jdbcType=VARCHAR},'%')) " +
            "</if> " +
            "<if test=\"params.authorId!='' and params.authorId!=null\">" +
            "AND" +
            " t.`author_id` = #{params.authorId,jdbcType=INTEGER}" +
            "</if>" +
            "</where>" +
            " ORDER BY t.`id` DESC" +
            "</script>")
    List<ArticleInfoParams> selectListByParams(@Param("params") ArticleInfoParams params);
}

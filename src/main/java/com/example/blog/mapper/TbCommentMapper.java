package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.TbCommentParams;
import com.example.blog.entity.TbComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 评论表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface TbCommentMapper extends BaseMapper<TbComment> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`user_id`" +
            " ,t.`article_id`" +
            " ,t.`parent_id`" +
            " ,t.`comment`" +
            " ,t.`create_time`" +
            " ,t.`is_deleted`" +
            " FROM tb_comment t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<TbComment> selectListByParams(@Param("params") TbCommentParams params, @Param("page") Page<TbComment> page);
}

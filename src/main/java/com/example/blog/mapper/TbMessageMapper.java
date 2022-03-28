package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.TbMessageParams;
import com.example.blog.entity.TbMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 留言表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface TbMessageMapper extends BaseMapper<TbMessage> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`user_id`" +
            " ,t.`avatar`" +
            " ,t.`content`" +
            " ,t.`create_time`" +
            " FROM tb_message t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<TbMessage> selectListByParams(@Param("params") TbMessageParams params, @Param("page") Page<TbMessage> page);
}

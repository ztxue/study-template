package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.TbFriendlinkParams;
import com.example.blog.entity.TbFriendlink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 友链表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface TbFriendlinkMapper extends BaseMapper<TbFriendlink> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`name`" +
            " ,t.`avatar`" +
            " ,t.`address`" +
            " ,t.`introduce`" +
            " ,t.`create_time`" +
            " FROM tb_friendLink t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<TbFriendlink> selectListByParams(@Param("params") TbFriendlinkParams params, @Param("page") Page<TbFriendlink> page);
}

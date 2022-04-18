package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.SysLogParams;
import com.example.blog.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * @author: 张童学
 * @description: 登录log表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`user_name`" +
            " ,t.`method`" +
            " ,t.`address`" +
            " ,t.`position`" +
            " ,t.`create_time`" +
            " FROM sys_log t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysLog> selectListByParams(@Param("params") SysLogParams params, @Param("page") Page<SysLog> page);
}

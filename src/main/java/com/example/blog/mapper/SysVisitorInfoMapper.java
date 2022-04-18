package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.SysVisitorInfoParams;
import com.example.blog.entity.SysVisitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * @author: 张童学
 * @description: 游客表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface SysVisitorInfoMapper extends BaseMapper<SysVisitorInfo> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`nick_name`" +
            " ,t.`avatar`" +
            " ,t.`address`" +
            " ,t.`position`" +
            " ,t.`create_time`" +
            " ,t.`last_login_time`" +
            " ,t.`is_enabled`" +
            " FROM sys_visitor_info t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysVisitorInfo> selectListByParams(@Param("params") SysVisitorInfoParams params, @Param("page") Page<SysVisitorInfo> page);
}

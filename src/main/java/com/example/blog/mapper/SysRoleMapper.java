package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.SysRoleParams;
import com.example.blog.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 角色表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`name`" +
            " ,t.`create_time`" +
            " ,t.`update_time`" +
            " ,t.`is_enabled`" +
            " FROM sys_role t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysRole> selectListByParams(@Param("params") SysRoleParams params, @Param("page") Page<SysRole> page);
}

package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.SysUserRoleParams;
import com.example.blog.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * @author: 张童学
 * @description: 用户角色管理表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`user_id`" +
            " ,t.`role_id`" +
            " FROM sys_user_role t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysUserRole> selectListByParams(@Param("params") SysUserRoleParams params, @Param("page") Page<SysUserRole> page);
}

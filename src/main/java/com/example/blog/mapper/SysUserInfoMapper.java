package com.example.blog.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.bean.LoginBean;
import com.example.blog.bean.SysUserInfoParams;
import com.example.blog.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * @author: 张童学
 * @description: 用户表 Mapper
 * @date: 2022-03-25
 */
@Mapper
public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`nick_name`" +
            " ,t.`user_name`" +
            " ,t.`password`" +
            " ,t.`phone`" +
            " ,t.`email`" +
            " ,t.`avatar`" +
            " ,t.`introduce`" +
            " ,t.`site`" +
            " ,t.`address`" +
            " ,t.`position`" +
            " ,t.`create_time`" +
            " ,t.`last_online_time`" +
            " ,t.`is_enabled`" +
            " FROM sys_user_info t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysUserInfo> selectListByParams(@Param("params") SysUserInfoParams params, @Param("page") Page<SysUserInfo> page);

    @Select("<script>" +
            "SELECT" +
            " COUNT(id) " +
            "FROM" +
            " sys_user_info u" +
            "<where>" +
            "<if test=\"params.loginName!='' and params.loginName!='null' and params.loginName!=null\">" +
            " u.`user_name` = #{params.loginName,jdbcType=VARCHAR} " +
            "</if>" +
            "<if test=\"params.loginEmail!='' and params.loginEmail!='null' and params.loginEmail!=null\">" +
            " AND u.`email` = #{params.loginEmail,jdbcType=VARCHAR} " +
            "</if>" +
            "<if test=\"params.loginPhone!='' and params.loginPhone!='null' and params.loginPhone!=null\">" +
            " AND u.`phone` = #{params.loginPhone,jdbcType=VARCHAR} " +
            "</if>" +
            "AND u.`password` = #{params.loginPassword,jdbcType=VARCHAR} " +
            "AND u.`is_enabled` = 0" +
            "</where>" +
            "</script>")
    int login(@Param("params") LoginBean params);
}

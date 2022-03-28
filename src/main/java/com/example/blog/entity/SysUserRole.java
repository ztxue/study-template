package com.example.blog.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.apache.ibatis.type.JdbcType;
import java.io.Serializable;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * @author: 张童学
 * @description: 用户角色管理表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "sys_user_role")
public class SysUserRole extends Model<SysUserRole> implements Serializable {

    private static final long serialVersionUID = -202203251610460022L;

    /**
     * 表ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 管理员ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_id`", jdbcType = JdbcType.INTEGER)
    private Integer userId;
    /**
     * 角色ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`role_id`", jdbcType = JdbcType.INTEGER)
    private Integer roleId;
}

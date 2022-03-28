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
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
/**
 * @author: 张童学
 * @description: 游客表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "sys_visitor_info")
public class SysVisitorInfo extends Model<SysVisitorInfo> implements Serializable {

    private static final long serialVersionUID = -202203251610460025L;

    /**
     * 游客ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 昵称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`nickname`", jdbcType = JdbcType.VARCHAR)
    private String nickname;
    /**
     * 游客头像
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`avatar`", jdbcType = JdbcType.VARCHAR)
    private String avatar;
    /**
     * 登录地址
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`address`", jdbcType = JdbcType.VARCHAR)
    private String address;
    /**
     * 登录地理位置
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`position`", jdbcType = JdbcType.VARCHAR)
    private String position;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 50)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 上次登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 60)
    @TableField(value = "`last_login_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date lastLoginTime;
    /**
     * 是否禁用，0否1是
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`is_enabled`", jdbcType = JdbcType.TINYINT)
    private Integer isEnabled;
}

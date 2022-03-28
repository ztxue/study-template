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
 * @description: 用户表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "sys_user_info")
public class SysUserInfo extends Model<SysUserInfo> implements Serializable {

    private static final long serialVersionUID = -202203251610460019L;

    /**
     * id
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`username`", jdbcType = JdbcType.VARCHAR)
    private String username;
    /**
     * 密码
     */
    @JSONField(serialize = false, ordinal = 20)
    @TableField(value = "`password`", jdbcType = JdbcType.VARCHAR)
    private String password;
    /**
     * 手机号
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`phone`", jdbcType = JdbcType.VARCHAR)
    private String phone;
    /**
     * 邮箱
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`email`", jdbcType = JdbcType.VARCHAR)
    private String email;
    /**
     * 用户头像
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`avatar`", jdbcType = JdbcType.VARCHAR)
    private String avatar;
    /**
     * 用户个人介绍
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`introduce`", jdbcType = JdbcType.VARCHAR)
    private String introduce;
    /**
     * 个人网站
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`site`", jdbcType = JdbcType.VARCHAR)
    private String site;
    /**
     * 登录地址
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`address`", jdbcType = JdbcType.VARCHAR)
    private String address;
    /**
     * 登录地理位置
     */
    @JSONField(ordinal = 90)
    @TableField(value = "`position`", jdbcType = JdbcType.VARCHAR)
    private String position;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 100)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 最后一次在线时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 110)
    @TableField(value = "`last_online_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date lastOnlineTime;
    /**
     * 是否禁用，0否1是
     */
    @JSONField(ordinal = 120)
    @TableField(value = "`is_enabled`", jdbcType = JdbcType.TINYINT)
    private Integer isEnabled;
}

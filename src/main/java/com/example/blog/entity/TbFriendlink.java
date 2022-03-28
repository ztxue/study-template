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
 * @description: 友链表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "tb_friendLink")
public class TbFriendlink extends Model<TbFriendlink> implements Serializable {

    private static final long serialVersionUID = -202203251610470031L;

    /**
     * 表ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 链接名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 头像地址
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`avatar`", jdbcType = JdbcType.VARCHAR)
    private String avatar;
    /**
     * 链接地址
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`address`", jdbcType = JdbcType.VARCHAR)
    private String address;
    /**
     * 网站简介
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`introduce`", jdbcType = JdbcType.VARCHAR)
    private String introduce;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 50)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
}

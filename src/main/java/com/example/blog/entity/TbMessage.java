package com.example.blog.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import java.io.Serializable;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
/**
 * @author: 张童学
 * @description: 留言表 实体类
 * @date: 2022-03-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "tb_message")
public class TbMessage extends Model<TbMessage> implements Serializable {

    private static final long serialVersionUID = -202203251610470034L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_id`", jdbcType = JdbcType.INTEGER)
    private Integer userId;
    /**
     * 用户头像
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`avatar`", jdbcType = JdbcType.VARCHAR)
    private String avatar;
    /**
     * 留言内容
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`content`", jdbcType = JdbcType.VARCHAR)
    private String content;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 40)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
}

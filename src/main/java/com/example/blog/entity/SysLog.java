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
 * @description: 登录log表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "sys_log")
public class SysLog extends Model<SysLog> implements Serializable {

    private static final long serialVersionUID = -202203251610460013L;

    /**
     * 操作ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_name`", jdbcType = JdbcType.VARCHAR)
    private String userName;
    /**
     * 请求方式
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`method`", jdbcType = JdbcType.VARCHAR)
    private String method;
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
}

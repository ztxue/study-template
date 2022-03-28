package com.example.blog.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.apache.ibatis.type.JdbcType;
import java.io.Serializable;
import java.math.BigInteger;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * @author: 张童学
 * @description: 区划信息 实体类
 * @date: 2022-01-26
 */
@Data
@TableName(value = "sys_area")
public class SysArea extends Model<SysArea> implements Serializable {

    private static final long serialVersionUID = -202201261050150004L;

    /**
     * ID主键
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 区划编码
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`code`", jdbcType = JdbcType.BIGINT)
    private BigInteger code;
    /**
     * 地区名称
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 父级区划编码
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`parent_code`", jdbcType = JdbcType.BIGINT)
    private BigInteger parentCode;
    /**
     * 排序
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 删除标识,0未删除,1删除
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 50)
    @TableField(value = "`deleted`", jdbcType = JdbcType.SMALLINT)
    private Integer deleted;
}

package com.example.demo1210.entity;

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
 * @description: 音色（发言人）管理 实体类
 * @date: 2022-02-21
 */
@Data
@TableName(value = "timbre")
public class Timbre extends Model<Timbre> implements Serializable {

    private static final long serialVersionUID = -202202211344090001L;

    /**
     * 主键唯一标识
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 音色名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 是否被删除(0-未删除 1-已删除)
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 20)
    @TableField(value = "`deleted`", jdbcType = JdbcType.INTEGER)
    private Integer deleted;
}

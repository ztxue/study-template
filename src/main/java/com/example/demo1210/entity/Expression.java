package com.example.demo1210.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import java.io.Serializable;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * @author: 张童学
 * @description:  实体类
 * @date: 2022-02-19
 */
@Setter
@Getter
@ToString
@TableName(value = "expression")
public class Expression extends Model<Expression> implements Serializable {

    private static final long serialVersionUID = -202202191339440001L;

    /**
     * 主键自增
     */
    @JSONField(ordinal = 1)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 花痴表情路径
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`anthomaniac`", jdbcType = JdbcType.VARCHAR)
    private String anthomaniac;
    /**
     * 唤醒表情路径
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`awaken`", jdbcType = JdbcType.VARCHAR)
    private String awaken;
    /**
     * 开心块乐表情路径
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`happy`", jdbcType = JdbcType.VARCHAR)
    private String happy;
    /**
     * 可爱表情路径
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`lovely`", jdbcType = JdbcType.VARCHAR)
    private String lovely;
    /**
     * 悲哀表情路径
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`sad`", jdbcType = JdbcType.VARCHAR)
    private String sad;
    /**
     * 害羞表情路径
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`shyness`", jdbcType = JdbcType.VARCHAR)
    private String shyness;
    /**
     * 遗憾、对不起表情路径
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`sorry`", jdbcType = JdbcType.VARCHAR)
    private String sorry;
    /**
     * 说话表情路径
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`speak`", jdbcType = JdbcType.VARCHAR)
    private String speak;
    /**
     * 思考表情路径
     */
    @JSONField(ordinal = 90)
    @TableField(value = "`think`", jdbcType = JdbcType.VARCHAR)
    private String think;
    /**
     * 休息睡觉表情路径
     */
    @JSONField(ordinal = 100)
    @TableField(value = "`unawaken`", jdbcType = JdbcType.VARCHAR)
    private String unawaken;
    /**
     * 尴尬表情路径
     */
    @JSONField(ordinal = 110)
    @TableField(value = "`awkward`", jdbcType = JdbcType.VARCHAR)
    private String awkward;
    /**
     * 骄傲自豪表情路径
     */
    @JSONField(ordinal = 120)
    @TableField(value = "`proud`", jdbcType = JdbcType.VARCHAR)
    private String proud;
    /**
     * 生气表情路径
     */
    @JSONField(ordinal = 130)
    @TableField(value = "`angry`", jdbcType = JdbcType.VARCHAR)
    private String angry;
    /**
     * 哭表情路径
     */
    @JSONField(ordinal = 140)
    @TableField(value = "`cry`", jdbcType = JdbcType.VARCHAR)
    private String cry;
}

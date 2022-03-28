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
 * @description: 文章表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "article_info")
public class ArticleInfo extends Model<ArticleInfo> implements Serializable {

    private static final long serialVersionUID = -202203251610460007L;

    /**
     * 文章ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 作者ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`author_id`", jdbcType = JdbcType.INTEGER)
    private Integer authorId;
    /**
     * 分类ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`category_id`", jdbcType = JdbcType.INTEGER)
    private Integer categoryId;
    /**
     * 文章标题
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`title`", jdbcType = JdbcType.VARCHAR)
    private String title;
    /**
     * 封面图
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`cover`", jdbcType = JdbcType.VARCHAR)
    private String cover;
    /**
     * 内容
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`content`", jdbcType = JdbcType.CLOB)
    private String content;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 60)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 70)
    @TableField(value = "`update_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date updateTime;
    /**
     * 是否置顶，0否1是
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`is_top`", jdbcType = JdbcType.TINYINT)
    private Integer isTop;
    /**
     * 是否为草稿，0否1是
     */
    @JSONField(ordinal = 90)
    @TableField(value = "`is_draft`", jdbcType = JdbcType.TINYINT)
    private Integer isDraft;
    /**
     * 是否删除，0否1是
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 100)
    @TableField(value = "`id_deleted`", jdbcType = JdbcType.TINYINT)
    private Integer idDeleted;
}

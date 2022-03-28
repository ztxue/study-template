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
/**
 * @author: 张童学
 * @description: 文章标签管理 实体类
 * @date: 2022-03-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "article_blog_tag")
public class ArticleBlogTag extends Model<ArticleBlogTag> implements Serializable {

    private static final long serialVersionUID = -202203251610450001L;

    /**
     * 标签关联ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`article_id`", jdbcType = JdbcType.INTEGER)
    private Integer articleId;
    /**
     * 标签ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`tag_id`", jdbcType = JdbcType.INTEGER)
    private Integer tagId;
}

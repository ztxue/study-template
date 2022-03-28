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
 * @description: 评论表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "tb_comment")
public class TbComment extends Model<TbComment> implements Serializable {

    private static final long serialVersionUID = -202203251610470028L;

    /**
     * 评论ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论用户ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_id`", jdbcType = JdbcType.INTEGER)
    private Integer userId;
    /**
     * 评论文章ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`article_id`", jdbcType = JdbcType.INTEGER)
    private Integer articleId;
    /**
     * 父评论ID
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`parent_id`", jdbcType = JdbcType.INTEGER)
    private Integer parentId;
    /**
     * 评论内容
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`comment`", jdbcType = JdbcType.CLOB)
    private String comment;
    /**
     * 评论时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 50)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 是否删除，0否1是
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 60)
    @TableField(value = "`is_deleted`", jdbcType = JdbcType.TINYINT)
    private Integer isDeleted;
}

package com.example.blog.bean;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author: 张童学
 * @description: 文章表 参数类
 * @date: 2022-03-25
 */

@Data
public class ArticleInfoParams {
    /**
     * 文章ID
     */
    private Integer id;
    /**
     * 作者
     */
    private Integer authorId;
    private String avatar;
    /**
     * 分类
     */
    private Integer categoryId;
    private String name;

    /**
     * 文章标题
     */
    private String title;
    /**
     * 笔名
     */
    private String nickName;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否置顶，0否1是
     */
    private Integer isTop;
    /**
     * 是否为草稿，0否1是
     */
    private Integer isDraft;
    /**
     * 是否删除，0否1是
     */
    private Integer idDeleted;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
//    /**
//     * 总页数
//     */
//    private Integer allPages;
//    /**
//     * 总行数
//     */
//    private Integer allRows;
}

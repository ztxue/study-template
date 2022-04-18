package com.example.blog.bean;
import lombok.Data;

import java.util.Date;


/**
 * @author: 张童学
 * @description: 用户表 参数类
 * @date: 2022-03-25
 */

@Data
public class SysUserInfoParams {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户个人介绍
     */
    private String introduce;
    /**
     * 个人网站
     */
    private String site;
    /**
     * 登录地址
     */
    private String address;
    /**
     * 登录地理位置
     */
    private String position;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次在线时间
     */
    private Date lastOnlineTime;
    /**
     * 是否禁用，0否1是
     */
    private Integer isEnabled;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}

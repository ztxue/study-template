package com.example.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.bean.LoginBean;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysUserInfoParams;
import com.example.blog.entity.SysUserInfo;

import java.util.Set;

/**
 * @author: 张童学
 * @description: 用户表 Service接口
 * @date: 2022-03-25
 */
public interface ISysUserInfoService extends IService<SysUserInfo> {
    /**
     * 查询列表
     */
    ResultList<SysUserInfo> list(SysUserInfoParams params);

    /**
     * 添加
     */
    int add(SysUserInfo entity);

    /**
     * 修改
     */
    int update(SysUserInfo entity);

    /**
     * 显示
     */
    SysUserInfo show(Integer id);

    /**
     * 删除
     */
    int delete(Set<Integer> ids);

    /**
     * 登录
     */
    int login(LoginBean bean);
    /**
     * 注册
     */
    int add(SysUserInfoParams params);
}

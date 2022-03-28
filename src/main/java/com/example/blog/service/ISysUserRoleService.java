package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysUserRoleParams;
import com.example.blog.entity.SysUserRole;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 用户角色管理表 Service接口
 * @date: 2022-03-25
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
    /**
     * 查询列表
     */
    ResultList<SysUserRole> list(SysUserRoleParams params);
    /**
     * 添加
     */
    int add(SysUserRole entity);
    /**
     * 修改
     */
    int update(SysUserRole entity);
    /**
     * 显示
     */
    SysUserRole show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

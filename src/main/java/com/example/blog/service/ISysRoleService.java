package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysRoleParams;
import com.example.blog.entity.SysRole;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 角色表 Service接口
 * @date: 2022-03-25
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 查询列表
     */
    ResultList<SysRole> list(SysRoleParams params);
    /**
     * 添加
     */
    int add(SysRole entity);
    /**
     * 修改
     */
    int update(SysRole entity);
    /**
     * 显示
     */
    SysRole show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

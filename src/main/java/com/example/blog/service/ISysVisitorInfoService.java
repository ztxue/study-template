package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysVisitorInfoParams;
import com.example.blog.entity.SysVisitorInfo;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 游客表 Service接口
 * @date: 2022-03-25
 */
public interface ISysVisitorInfoService extends IService<SysVisitorInfo> {
    /**
     * 查询列表
     */
    ResultList<SysVisitorInfo> list(SysVisitorInfoParams params);
    /**
     * 添加
     */
    int add(SysVisitorInfo entity);
    /**
     * 修改
     */
    int update(SysVisitorInfo entity);
    /**
     * 显示
     */
    SysVisitorInfo show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

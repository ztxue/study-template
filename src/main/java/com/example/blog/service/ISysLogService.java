package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysLogParams;
import com.example.blog.entity.SysLog;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 登录log表 Service接口
 * @date: 2022-03-25
 */
public interface ISysLogService extends IService<SysLog> {
    /**
     * 查询列表
     */
    ResultList<SysLog> list(SysLogParams params);
    /**
     * 添加
     */
    int add(SysLog entity);
    /**
     * 修改
     */
    int update(SysLog entity);
    /**
     * 显示
     */
    SysLog show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

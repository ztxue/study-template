package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.SysAreaParams;
import com.example.blog.entity.SysArea;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 区划信息 Service接口
 * @date: 2022-01-26
 */
public interface ISysAreaService extends IService<SysArea> {


    /**
     * 查询列表
     */
    ResultList<SysArea> list(SysAreaParams params);
    /**
     * 添加
     */
    int add(SysArea entity);
    /**
     * 修改
     */
    int update(SysArea entity);
    /**
     * 显示
     */
    SysArea show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

package com.example.demo1210.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1210.result.ResultList;
import com.example.demo1210.bean.SysAreaParams;
import com.example.demo1210.entity.SysArea;
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

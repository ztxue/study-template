package com.example.demo1210.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1210.entity.Timbre;

import java.util.List;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 音色（发言人）管理 Service接口
 * @date: 2022-02-21
 */
public interface ITimbreService extends IService<Timbre> {
    /**
     * 查询列表
     */
    List<Timbre> listTimbre();
    List<Timbre> listById(Integer id);
    /**
     * 添加
     */
    int add(Timbre entity);
    /**
     * 修改
     */
    int update(Timbre entity);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);

}

package com.example.demo1210.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1210.entity.Timbre;
import com.example.demo1210.mapper.TimbreMapper;
import com.example.demo1210.result.HttpRuntimeException;
import com.example.demo1210.result.ResultEnum;
import com.example.demo1210.service.ITimbreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: 音色（发言人）管理 ServiceImpl
 * @date: 2022-02-21
 */
@Slf4j
@Service("timbreServiceImpl")
public class TimbreServiceImpl extends ServiceImpl<TimbreMapper, Timbre> implements ITimbreService {

    private final TimbreMapper timbreMapper;

    public TimbreServiceImpl(TimbreMapper timbreMapper) {
        this.timbreMapper = timbreMapper;
    }

    /**
     * 查询列表
     */
    @Override
    public List<Timbre> listTimbre() {
        QueryWrapper<Timbre> wrapper = new QueryWrapper<>();
        wrapper
                .select("id", "name")
                .ne("deleted", 1);
        return timbreMapper.selectList(wrapper);
    }

    /**
     * 查询byId
     */
    @Override
    public List<Timbre> listById(Integer id) {
        QueryWrapper<Timbre> wrapper = new QueryWrapper<>();
        wrapper
                .select("id", "name")
                .ne("deleted", 1)
                .eq("id",id);
        Timbre timbre = baseMapper.selectOne(wrapper);
        List<Timbre> list = new ArrayList<>();
        list.add(timbre);
        return list;
    }

    /**
     * 添加
     */
    @Override
    public int add(Timbre entity) {
        //查重
        int check = timbreMapper.check(entity.getName());
        if (check == 1) {
            throw new HttpRuntimeException("500","已包含同名数据");
        }
        return timbreMapper.insert(entity);
    }

    /**
     * 修改
     */
    @Override
    public int update(Timbre entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return timbreMapper.updateById(entity);
    }

    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return timbreMapper.deleteBatchIds(ids);
    }


}

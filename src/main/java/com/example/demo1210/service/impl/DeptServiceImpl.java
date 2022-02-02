package com.example.demo1210.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.entity.Dept;
import com.example.demo1210.mapper.DeptMapper;
import com.example.demo1210.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Slf4j
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {


    @Autowired
    DeptMapper deptMapper;


    public List<Dept> listNoParams() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    /**
     * listPage 自定义的方法
     */
    @Override
    public List<Dept> selectListPage(DeptBean param) {

        if (param == null) {
            param = new DeptBean();
        }
        Integer pageSize = param.getPageSize();
        Integer currentPage = param.getCurrentPage();
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        Page<Dept> page = new Page<>(currentPage, pageSize);
        IPage<Dept> deptPage = deptMapper.selectListPage(param, page);

        return deptPage.getRecords();
    }

    //list分页map
    @Override
    public Object listP(Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();

        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            queryWrapper.like("user_name", map.get("username"));
            queryWrapper.like("name", map.get("name"));

        }
        Integer currentPage = (Integer) map.put("currentPage", "currentPage");
        Integer pageSize = (Integer) map.put("pageSize", "pageSize");


        Page<Map<String, Object>> page = new Page<>(currentPage, pageSize);
        IPage<Map<String, Object>> iPage = deptMapper.selectMapsPage(page, queryWrapper);

        resultMap.put("page", iPage.getRecords());
        return resultMap;
    }


    @Override
    public int getOne(int id) {
        return deptMapper.getOne(id);
    }

    @Override
    public int deleteByName(String name) {
        return deptMapper.deleteByName(name);
    }

    @Override
    public int updateTelByName(String tel) {
        return deptMapper.updateTelByName(tel);
    }

    @Override
    public int addDept(DeptBean deptBean) {
        return deptMapper.addDept(deptBean);
    }

    //查重用
    @Override
    public int getOneByName(String userName) {

        return deptMapper.getOneByName(userName);
    }


}

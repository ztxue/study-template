package com.example.demo1210.service.impl;

import com.example.demo1210.entity.Dept;
import com.example.demo1210.mapper.DeptMapper;
import com.example.demo1210.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {


    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> deptList() {
        return deptMapper.deptList();
    }

    @Override
    public int getOne(int id) {
        return deptMapper.getOne(id);
    }

    @Override
    public int selectCountByOrgId(Set<Integer> ids) {
        return deptMapper.selectCountByOrgId(ids);
    }

    @Override
    public int deleteByName(String name) {
        return deptMapper.deleteByName(name);
    }

    @Override
    public int updateTelByName( String tel) {
        return deptMapper.updateTelByName(tel);
    }

    @Override
    public int addDept(String name, Integer levels, String username, String tel) {
        return deptMapper.addDept(name, levels, username, tel);
    }
}

package com.example.demo1210.service;

import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
public interface DeptService extends IService<Dept> {

    List<Dept> selectListPage(DeptBean param);

    Object listP(Map<String, Object> map);

    List<Dept> deptList(DeptBean deptBean);

    int getOne(int id);

    Dept selectCountByOrgId(Set<Integer> ids);

    int deleteByName(String name);

    int updateTelByName(String tel);

    int addDept(DeptBean deptBean);
}

package com.example.demo1210.service;

import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    int deleteByName(String name);

    int updateTelByName(String tel);

    int addDept(DeptBean deptBean);

    //用作查重
    int getOneByName(@Param("userName") String userName);

}

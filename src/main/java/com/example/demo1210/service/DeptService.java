package com.example.demo1210.service;

import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    List<Dept> deptList();
    int getOne(@Param("id") int id);
    int selectCountByOrgId(@Param("ids") Set<Integer> ids);
}

package com.example.demo1210.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1210.bean.StaffBean;
import com.example.demo1210.entity.Staff;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
public interface StaffService extends IService<Staff> {
    /**
     * add
     */
    int addStaff(Staff staff);
    /**
     * 用作查重
     */
    int getOneByName(String userName);
    /**
     * login
     */
    StaffBean login(@Param("userName") String loginName, @Param("password") String loginPassword);

}

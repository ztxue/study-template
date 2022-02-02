package com.example.demo1210.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1210.bean.StaffBean;
import com.example.demo1210.entity.Staff;
import com.example.demo1210.mapper.DeptMapper;
import com.example.demo1210.mapper.StaffMapper;
import com.example.demo1210.service.StaffService;
import com.example.demo1210.util.AesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    StaffMapper staffMapper;
    @Autowired
    DeptMapper deptMapper;

    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "ZTXSTUDY666";
    /**
     * 注册
     */
    @Override
    public int addStaff(Staff staff) {

        if (!StringUtils.isEmpty(staff.getPassword())) {
            staff.setPassword(AesUtil.encrypt(staff.getPassword(),SECRET_KEY));
        }
        staff.setDeptId(deptMapper.getDeptIdByName(staff.getDeptName()));
        staff.setGmtCreate(new Date());
        staff.setGmtModified(new Date());
        staff.setLevels(deptMapper.getLevelsByDeptName(staff.getDeptName()));
        return staffMapper.insert(staff);
    }

    /**
     * 查重
     */
    @Override
    public int getOneByName(String userName) {
        return staffMapper.getOneByName(userName);
    }

    /**
     * 登录
     */
    @Override
    public StaffBean login(String loginName, String loginPassword) {
        return staffMapper.login(loginName,loginPassword);
    }

}

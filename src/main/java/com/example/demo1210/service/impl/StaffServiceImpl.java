package com.example.demo1210.service.impl;

import com.example.demo1210.entity.Dept;
import com.example.demo1210.entity.Staff;
import com.example.demo1210.mapper.DeptMapper;
import com.example.demo1210.mapper.StaffMapper;
import com.example.demo1210.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

}

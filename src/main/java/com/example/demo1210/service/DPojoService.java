package com.example.demo1210.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1210.entity.DPojo;

import java.util.List;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/5 13:53
 * @describe
 */
public interface DPojoService extends IService<DPojo> {

    List<DPojo> getAllOneTwoSubject(int id);
}

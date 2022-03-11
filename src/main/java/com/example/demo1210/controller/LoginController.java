package com.example.demo1210.controller;


import com.example.demo1210.bean.LoginBean;
import com.example.demo1210.bean.StaffBean;
import com.example.demo1210.entity.Staff;
import com.example.demo1210.result.R;
import com.example.demo1210.service.StaffService;
import com.example.demo1210.util.AesUtil;
import com.example.demo1210.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张童学
 * @version 1.0
 * @date 2021/12/31 15:32
 * @describe
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {

    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "ZTXSTUDY666";

    @Autowired
    StaffService staffService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * login
     */
    @PostMapping("login")
    public R<Object> staffLogin(@RequestBody LoginBean bean) {
        if (bean == null) {
            return R.argsNull();
        }
        if (StringUtils.isBlank(bean.getLoginName())) {
            return R.fail("用户名不能为空!");
        }
        if (StringUtils.isBlank(bean.getLoginPassword())) {
            return R.fail("密码不能为空!");
        }
        StaffBean loginBean = staffService.login(bean.getLoginName(), AesUtil.encrypt(bean.getLoginPassword(), SECRET_KEY));
        System.out.println("密码-->" + AesUtil.encrypt(bean.getLoginPassword(), SECRET_KEY));

        if (loginBean == null || loginBean.getUserId() == null) {
            return R.fail("用户不存在或密码错误!");
        }

        Map<String, Object> map = new HashMap<>();
        //生成token
        map.put("userInfo", loginBean.getUserName());
        String token = JwtUtil.sign(map);


        return R.success(token);

    }

    /**
     * regis
     */
    @PostMapping("regis")
    public R<Integer> staffRegister(Staff staff) {
        if (staff == null) {
            return R.argsNull();
        }
        if (staffService.getOneByName(staff.getUserName()) > 0) {
            return R.fail("用户名已存在!");
        }
        if (staffService.addStaff(staff) > 0) {

            return R.success();
        }

        return R.fail();

    }

}

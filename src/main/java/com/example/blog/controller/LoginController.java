package com.example.blog.controller;


import com.example.blog.bean.LoginBean;
import com.example.blog.bean.SysUserInfoParams;
import com.example.blog.result.R;
import com.example.blog.result.ResultSuccess;
import com.example.blog.service.ISysUserInfoService;
import com.example.blog.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张童学
 * @version 1.0
 * @date 2021/12/31 15:32
 * @describe
 */
@RestController
@RequestMapping("/")
public class LoginController {


    private final ISysUserInfoService sysUserInfoServiceImpl;
    private final RedisTemplate<String, Object> redisTemplate;

    public LoginController(ISysUserInfoService sysUserInfoServiceImpl, RedisTemplate<String, Object> redisTemplate) {
        this.sysUserInfoServiceImpl = sysUserInfoServiceImpl;
        this.redisTemplate = redisTemplate;
    }

    /**
     * login
     */
    @PostMapping("login")
    public R<Object> staffLogin(@RequestBody LoginBean bean) {
        if (bean == null) {
            return R.argsNull();
        }
        if (StringUtils.isBlank(bean.getLoginName()) && StringUtils.isBlank(bean.getLoginPhone()) && StringUtils.isBlank(bean.getLoginEmail())) {
            return R.fail("账号不能为空!");
        }
        if (StringUtils.isBlank(bean.getLoginPassword())) {
            return R.fail("密码不能为空!");
        }
        int count = sysUserInfoServiceImpl.login(bean);
        if (count == -1) {
            return R.fail("账号不存在");
        }
        if (count == -2) {
            return R.fail("账号被封禁");
        }
        if (count == 0) {
            return R.fail("密码错误!");
        }

        Map<String, Object> map = new HashMap<>(16);
        //生成token
        map.put("userInfo", bean.getLoginPassword());
        String token = JwtUtil.sign(map);

        ResultSuccess<Object> success = new ResultSuccess<>();
        success.setSuccess(token);
        return R.success(success);

    }

    /**
     * regis
     */
    @PostMapping("regis")
    public R<Integer> staffRegister(@RequestBody SysUserInfoParams params) {
        if (!StringUtils.isBlank(params.getUserName())) {
            if (StringUtils.isBlank(params.getPassword())) {
                return R.fail("请输入密码!");
            }
            int add = sysUserInfoServiceImpl.add(params);
            return add > 0 ? R.success("注册成功!") : R.fail("注册失败!");
        }
        return R.fail("请输入账号!");
    }
}

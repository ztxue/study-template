package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.bean.LoginBean;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.SysUserInfoParams;
import com.example.blog.entity.SysUserInfo;
import com.example.blog.mapper.SysUserInfoMapper;
import com.example.blog.service.ISysUserInfoService;
import com.example.blog.util.AesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * @author: 张童学
 * @description: 用户表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("sysUserInfoServiceImpl")
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfo> implements ISysUserInfoService {
    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "ZTXSTUDY666";

    private final SysUserInfoMapper sysUserInfoMapper;

    public SysUserInfoServiceImpl(SysUserInfoMapper sysUserInfoMapper) {
        this.sysUserInfoMapper = sysUserInfoMapper;
    }

    /**
     * 查询列表
     */
    @Override
    public ResultList<SysUserInfo> list(SysUserInfoParams params) {
        if (params == null) {
            params = new SysUserInfoParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<SysUserInfo> page = new Page<>(currentPage, pageSize);
        IPage<SysUserInfo> iPage = sysUserInfoMapper.selectListByParams(params, page);
        ResultList<SysUserInfo> resultList = new ResultList<>();
        resultList.setList(iPage.getRecords());
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(iPage.getCurrent());
        pageBean.setPageSize(iPage.getSize());
        pageBean.setAllRows(iPage.getTotal());
        pageBean.setAllPages(iPage.getPages());
        resultList.setPage(pageBean);
        return resultList;
    }

    /**
     * 添加
     */
    @Override
    public int add(SysUserInfo entity) {
        entity.setCreateTime(new Date());
        return sysUserInfoMapper.insert(entity);
    }

    /**
     * 修改
     */
    @Override
    public int update(SysUserInfo entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserInfoMapper.updateById(entity);
    }

    /**
     * 详情
     */
    @Override
    public SysUserInfo show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserInfoMapper.selectById(id);
    }

    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserInfoMapper.deleteBatchIds(ids);
    }

    /**
     * 登录
     */
    @Override
    public int login(LoginBean bean) {
        //密码加密
        bean.setLoginPassword(AesUtil.encrypt(bean.getLoginPassword(), SECRET_KEY));
        //账号封禁否
        Long enable = sysUserInfoMapper.selectCount(new QueryWrapper<SysUserInfo>()
                .select("id")
                .eq(bean.getLoginName() != null, "username", bean.getLoginName())
                .eq(bean.getLoginPhone() != null, "phone", bean.getLoginPhone())
                .eq(bean.getLoginEmail() != null, "email", bean.getLoginEmail())
                .eq("is_enabled", 1));
        if (enable == 1) {
            return -2;
        }
        //账号存在否
        Long count = sysUserInfoMapper.selectCount(new QueryWrapper<SysUserInfo>()
                .select("id")
                .eq(bean.getLoginName() != null, "username", bean.getLoginName())
                .eq(bean.getLoginPhone() != null, "phone", bean.getLoginPhone())
                .eq(bean.getLoginEmail() != null, "email", bean.getLoginEmail())
                .eq("is_enabled", 0));
        return count == 0 ? -1 : sysUserInfoMapper.login(bean);
    }

    /**
     * 注册
     */
    @Override
    public int add(SysUserInfoParams params) {
        SysUserInfo pojo = new SysUserInfo();
        pojo.setUsername(params.getUsername());
        pojo.setPassword(AesUtil.encrypt(params.getPassword(), SECRET_KEY));
        pojo.setPhone(params.getPhone());
        pojo.setEmail(params.getEmail());
        pojo.setCreateTime(new Date());

        return sysUserInfoMapper.insert(pojo);
    }

}

package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.SysVisitorInfoParams;
import com.example.blog.entity.SysVisitorInfo;
import com.example.blog.mapper.SysVisitorInfoMapper;
import com.example.blog.service.ISysVisitorInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 游客表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("sysVisitorInfoServiceImpl")
public class SysVisitorInfoServiceImpl extends ServiceImpl<SysVisitorInfoMapper, SysVisitorInfo> implements ISysVisitorInfoService {

    private final SysVisitorInfoMapper sysVisitorInfoMapper;
    public SysVisitorInfoServiceImpl(SysVisitorInfoMapper sysVisitorInfoMapper) {
        this.sysVisitorInfoMapper = sysVisitorInfoMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<SysVisitorInfo> list(SysVisitorInfoParams params) {
        if (params == null) {
                params = new SysVisitorInfoParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<SysVisitorInfo> page = new Page<>(currentPage, pageSize);
        IPage<SysVisitorInfo> iPage = sysVisitorInfoMapper.selectListByParams(params, page);
        ResultList<SysVisitorInfo> resultList = new ResultList<>();
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
    public int add(SysVisitorInfo entity) {
        entity.setCreateTime(new Date());
        return sysVisitorInfoMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(SysVisitorInfo entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysVisitorInfoMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public SysVisitorInfo show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysVisitorInfoMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysVisitorInfoMapper.deleteBatchIds(ids);
    }
}

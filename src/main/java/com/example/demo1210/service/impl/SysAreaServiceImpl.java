package com.example.demo1210.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.result.ResultEnum;
import com.example.demo1210.result.ResultList;
import com.example.demo1210.result.HttpRuntimeException;
import com.example.demo1210.result.PageBean;
import com.example.demo1210.bean.SysAreaParams;
import com.example.demo1210.entity.SysArea;
import com.example.demo1210.mapper.SysAreaMapper;
import com.example.demo1210.service.ISysAreaService;
import com.example.demo1210.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: 区划信息 ServiceImpl
 * @date: 2022-01-26
 */
@Slf4j
@Service("sysAreaServiceImpl")
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {

    private final SysAreaMapper sysAreaMapper;

    public SysAreaServiceImpl(SysAreaMapper sysAreaMapper) {
        this.sysAreaMapper = sysAreaMapper;
    }

    //工具类树
    public List<TreeNode> getTree() {
        List<TreeNode> treeNodes = sysAreaMapper.getTree();
        return TreeUtil.build(treeNodes);
    }



    /**
     * 查询列表
     */
    @Override
    public ResultList<SysArea> list(SysAreaParams params) {
        if (params == null) {
            params = new SysAreaParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<SysArea> page = new Page<>(currentPage, pageSize);
        IPage<SysArea> iPage = sysAreaMapper.selectListByParams(params, page);
        ResultList<SysArea> resultList = new ResultList<>();
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
    public int add(SysArea entity) {
        return sysAreaMapper.insert(entity);
    }

    /**
     * 修改
     */
    @Override
    public int update(SysArea entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysAreaMapper.updateById(entity);
    }

    /**
     * 详情
     */
    @Override
    public SysArea show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysAreaMapper.selectById(id);
    }

    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysAreaMapper.deleteBatchIds(ids);
    }
}

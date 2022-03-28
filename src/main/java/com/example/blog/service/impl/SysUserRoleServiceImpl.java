package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.SysUserRoleParams;
import com.example.blog.entity.SysUserRole;
import com.example.blog.mapper.SysUserRoleMapper;
import com.example.blog.service.ISysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 用户角色管理表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("sysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    private final SysUserRoleMapper sysUserRoleMapper;
    public SysUserRoleServiceImpl(SysUserRoleMapper sysUserRoleMapper) {
        this.sysUserRoleMapper = sysUserRoleMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<SysUserRole> list(SysUserRoleParams params) {
        if (params == null) {
                params = new SysUserRoleParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<SysUserRole> page = new Page<>(currentPage, pageSize);
        IPage<SysUserRole> iPage = sysUserRoleMapper.selectListByParams(params, page);
        ResultList<SysUserRole> resultList = new ResultList<>();
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
    public int add(SysUserRole entity) {
        return sysUserRoleMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(SysUserRole entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserRoleMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public SysUserRole show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserRoleMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysUserRoleMapper.deleteBatchIds(ids);
    }
}

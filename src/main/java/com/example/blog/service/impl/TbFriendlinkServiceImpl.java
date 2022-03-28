package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.TbFriendlinkParams;
import com.example.blog.entity.TbFriendlink;
import com.example.blog.mapper.TbFriendlinkMapper;
import com.example.blog.service.ITbFriendlinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 友链表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("tbFriendlinkServiceImpl")
public class TbFriendlinkServiceImpl extends ServiceImpl<TbFriendlinkMapper, TbFriendlink> implements ITbFriendlinkService {

    private final TbFriendlinkMapper tbFriendlinkMapper;
    public TbFriendlinkServiceImpl(TbFriendlinkMapper tbFriendlinkMapper) {
        this.tbFriendlinkMapper = tbFriendlinkMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<TbFriendlink> list(TbFriendlinkParams params) {
        if (params == null) {
                params = new TbFriendlinkParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<TbFriendlink> page = new Page<>(currentPage, pageSize);
        IPage<TbFriendlink> iPage = tbFriendlinkMapper.selectListByParams(params, page);
        ResultList<TbFriendlink> resultList = new ResultList<>();
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
    public int add(TbFriendlink entity) {
        entity.setCreateTime(new Date());
        return tbFriendlinkMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(TbFriendlink entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbFriendlinkMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public TbFriendlink show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbFriendlinkMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbFriendlinkMapper.deleteBatchIds(ids);
    }
}

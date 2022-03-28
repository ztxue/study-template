package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.TbMessageParams;
import com.example.blog.entity.TbMessage;
import com.example.blog.mapper.TbMessageMapper;
import com.example.blog.service.ITbMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 留言表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("tbMessageServiceImpl")
public class TbMessageServiceImpl extends ServiceImpl<TbMessageMapper, TbMessage> implements ITbMessageService {

    private final TbMessageMapper tbMessageMapper;
    public TbMessageServiceImpl(TbMessageMapper tbMessageMapper) {
        this.tbMessageMapper = tbMessageMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<TbMessage> list(TbMessageParams params) {
        if (params == null) {
                params = new TbMessageParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<TbMessage> page = new Page<>(currentPage, pageSize);
        IPage<TbMessage> iPage = tbMessageMapper.selectListByParams(params, page);
        ResultList<TbMessage> resultList = new ResultList<>();
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
    public int add(TbMessage entity) {
        entity.setCreateTime(new Date());
        return tbMessageMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(TbMessage entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbMessageMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public TbMessage show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbMessageMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbMessageMapper.deleteBatchIds(ids);
    }
}

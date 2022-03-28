package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.TbCommentParams;
import com.example.blog.entity.TbComment;
import com.example.blog.mapper.TbCommentMapper;
import com.example.blog.service.ITbCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 评论表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("tbCommentServiceImpl")
public class TbCommentServiceImpl extends ServiceImpl<TbCommentMapper, TbComment> implements ITbCommentService {

    private final TbCommentMapper tbCommentMapper;
    public TbCommentServiceImpl(TbCommentMapper tbCommentMapper) {
        this.tbCommentMapper = tbCommentMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<TbComment> list(TbCommentParams params) {
        if (params == null) {
                params = new TbCommentParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<TbComment> page = new Page<>(currentPage, pageSize);
        IPage<TbComment> iPage = tbCommentMapper.selectListByParams(params, page);
        ResultList<TbComment> resultList = new ResultList<>();
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
    public int add(TbComment entity) {
        entity.setCreateTime(new Date());
        return tbCommentMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(TbComment entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbCommentMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public TbComment show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbCommentMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return tbCommentMapper.deleteBatchIds(ids);
    }
}

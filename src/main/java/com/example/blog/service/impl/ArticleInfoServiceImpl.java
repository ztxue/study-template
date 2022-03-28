package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.ArticleInfoParams;
import com.example.blog.entity.ArticleInfo;
import com.example.blog.mapper.ArticleInfoMapper;
import com.example.blog.service.IArticleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 文章表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("articleInfoServiceImpl")
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

    private final ArticleInfoMapper articleInfoMapper;
    public ArticleInfoServiceImpl(ArticleInfoMapper articleInfoMapper) {
        this.articleInfoMapper = articleInfoMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<ArticleInfo> list(ArticleInfoParams params) {
        if (params == null) {
                params = new ArticleInfoParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<ArticleInfo> page = new Page<>(currentPage, pageSize);
        IPage<ArticleInfo> iPage = articleInfoMapper.selectListByParams(params, page);
        ResultList<ArticleInfo> resultList = new ResultList<>();
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
    public int add(ArticleInfo entity) {
        entity.setCreateTime(new Date());
        return articleInfoMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(ArticleInfo entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleInfoMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public ArticleInfo show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleInfoMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleInfoMapper.deleteBatchIds(ids);
    }
}

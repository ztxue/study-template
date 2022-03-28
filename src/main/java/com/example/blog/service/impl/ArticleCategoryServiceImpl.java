package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.ArticleCategoryParams;
import com.example.blog.entity.ArticleCategory;
import com.example.blog.mapper.ArticleCategoryMapper;
import com.example.blog.service.IArticleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 分类表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("articleCategoryServiceImpl")
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {

    private final ArticleCategoryMapper articleCategoryMapper;
    public ArticleCategoryServiceImpl(ArticleCategoryMapper articleCategoryMapper) {
        this.articleCategoryMapper = articleCategoryMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<ArticleCategory> list(ArticleCategoryParams params) {
        if (params == null) {
                params = new ArticleCategoryParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<ArticleCategory> page = new Page<>(currentPage, pageSize);
        IPage<ArticleCategory> iPage = articleCategoryMapper.selectListByParams(params, page);
        ResultList<ArticleCategory> resultList = new ResultList<>();
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
    public int add(ArticleCategory entity) {
        entity.setCreateTime(new Date());
        return articleCategoryMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(ArticleCategory entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleCategoryMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public ArticleCategory show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleCategoryMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleCategoryMapper.deleteBatchIds(ids);
    }
}

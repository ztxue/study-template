package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.ArticleTagParams;
import com.example.blog.entity.ArticleTag;
import com.example.blog.mapper.ArticleTagMapper;
import com.example.blog.service.IArticleTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 标签表 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("articleTagServiceImpl")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements IArticleTagService {

    private final ArticleTagMapper articleTagMapper;
    public ArticleTagServiceImpl(ArticleTagMapper articleTagMapper) {
        this.articleTagMapper = articleTagMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<ArticleTag> list(ArticleTagParams params) {
        if (params == null) {
                params = new ArticleTagParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<ArticleTag> page = new Page<>(currentPage, pageSize);
        IPage<ArticleTag> iPage = articleTagMapper.selectListByParams(params, page);
        ResultList<ArticleTag> resultList = new ResultList<>();
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
    public int add(ArticleTag entity) {
        entity.setCreateTime(new Date());
        return articleTagMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(ArticleTag entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleTagMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public ArticleTag show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleTagMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleTagMapper.deleteBatchIds(ids);
    }
}

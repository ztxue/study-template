package com.example.blog.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.result.ResultEnum;
import com.example.blog.result.ResultList;
import com.example.blog.result.HttpRuntimeException;
import com.example.blog.result.PageBean;
import com.example.blog.bean.ArticleBlogTagParams;
import com.example.blog.entity.ArticleBlogTag;
import com.example.blog.mapper.ArticleBlogTagMapper;
import com.example.blog.service.IArticleBlogTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 文章标签管理 ServiceImpl
 * @date: 2022-03-25
 */
@Slf4j
@Service("articleBlogTagServiceImpl")
public class ArticleBlogTagServiceImpl extends ServiceImpl<ArticleBlogTagMapper, ArticleBlogTag> implements IArticleBlogTagService {

    private final ArticleBlogTagMapper articleBlogTagMapper;
    public ArticleBlogTagServiceImpl(ArticleBlogTagMapper articleBlogTagMapper) {
        this.articleBlogTagMapper = articleBlogTagMapper;
    }
    /**
     * 查询列表
     */
    @Override
    public ResultList<ArticleBlogTag> list(ArticleBlogTagParams params) {
        if (params == null) {
                params = new ArticleBlogTagParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<ArticleBlogTag> page = new Page<>(currentPage, pageSize);
        IPage<ArticleBlogTag> iPage = articleBlogTagMapper.selectListByParams(params, page);
        ResultList<ArticleBlogTag> resultList = new ResultList<>();
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
    public int add(ArticleBlogTag entity) {
        return articleBlogTagMapper.insert(entity);
    }
    /**
     * 修改
     */
    @Override
    public int update(ArticleBlogTag entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleBlogTagMapper.updateById(entity);
    }
    /**
     * 详情
     */
    @Override
    public ArticleBlogTag show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleBlogTagMapper.selectById(id);
    }
    /**
     * 删除
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return articleBlogTagMapper.deleteBatchIds(ids);
    }
}

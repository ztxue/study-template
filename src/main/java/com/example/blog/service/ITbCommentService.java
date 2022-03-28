package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.TbCommentParams;
import com.example.blog.entity.TbComment;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 评论表 Service接口
 * @date: 2022-03-25
 */
public interface ITbCommentService extends IService<TbComment> {
    /**
     * 查询列表
     */
    ResultList<TbComment> list(TbCommentParams params);
    /**
     * 添加
     */
    int add(TbComment entity);
    /**
     * 修改
     */
    int update(TbComment entity);
    /**
     * 显示
     */
    TbComment show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.TbMessageParams;
import com.example.blog.entity.TbMessage;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 留言表 Service接口
 * @date: 2022-03-25
 */
public interface ITbMessageService extends IService<TbMessage> {
    /**
     * 查询列表
     */
    ResultList<TbMessage> list(TbMessageParams params);
    /**
     * 添加
     */
    int add(TbMessage entity);
    /**
     * 修改
     */
    int update(TbMessage entity);
    /**
     * 显示
     */
    TbMessage show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

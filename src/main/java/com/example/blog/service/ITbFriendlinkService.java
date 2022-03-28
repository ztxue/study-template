package com.example.blog.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.result.ResultList;
import com.example.blog.bean.TbFriendlinkParams;
import com.example.blog.entity.TbFriendlink;
import java.util.Set;
/**
 * @author: 张童学
 * @description: 友链表 Service接口
 * @date: 2022-03-25
 */
public interface ITbFriendlinkService extends IService<TbFriendlink> {
    /**
     * 查询列表
     */
    ResultList<TbFriendlink> list(TbFriendlinkParams params);
    /**
     * 添加
     */
    int add(TbFriendlink entity);
    /**
     * 修改
     */
    int update(TbFriendlink entity);
    /**
     * 显示
     */
    TbFriendlink show(Integer id);
    /**
     * 删除
     */
    int delete(Set<Integer> ids);
}

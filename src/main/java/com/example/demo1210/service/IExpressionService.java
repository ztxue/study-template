package com.example.demo1210.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo1210.entity.Expression;

import java.util.List;
import java.util.Set;
/**
 * @author: 张童学
 * @description:  Service接口
 * @date: 2022-02-19
 */
public interface IExpressionService extends IService<Expression> {
    /**
     * 查询列表Byid
     */
    List<Expression> listId(Integer id);
    /**
     * 添加
     */
    int add(Expression entity);
    /**
     * 修改
     */
    int updateByE(Expression entity);
    /**
     * 删除
     */
    int deleteE(Set<Integer> ids);

}

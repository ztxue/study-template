package com.example.demo1210.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1210.entity.Expression;
import com.example.demo1210.mapper.ExpressionMapper;
import com.example.demo1210.result.HttpRuntimeException;
import com.example.demo1210.result.ResultEnum;
import com.example.demo1210.service.IExpressionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: ServiceImpl
 * @date: 2022-02-19
 */
@Slf4j
@Service("expressionServiceImpl")
public class ExpressionServiceImpl extends ServiceImpl<ExpressionMapper, Expression> implements IExpressionService {

    private final ExpressionMapper expressionMapper;

    public ExpressionServiceImpl(ExpressionMapper expressionMapper) {
        this.expressionMapper = expressionMapper;
    }

    /**
     * 查询列表Byid
     */
    @Override
    public List<Expression> listId(Integer id) {
        Expression expression = expressionMapper.selectById(id);
        List<Expression> list = new ArrayList<>();
        list.add(expression);
        return list;
    }

    /**
     * 添加
     */
    @Override
    public int add(Expression entity) {
        return expressionMapper.insert(entity);
    }

    /**
     * 修改
     */
    @Override
    public int updateByE(Expression entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return expressionMapper.updateById(entity);
    }

    /**
     * 删除
     */
    @Override
    public int deleteE(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return expressionMapper.deleteExpression(ids);
    }

}

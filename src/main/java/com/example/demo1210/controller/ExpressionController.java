package com.example.demo1210.controller;

import com.example.demo1210.entity.Expression;
import com.example.demo1210.result.R;
import com.example.demo1210.result.ResultSuccess;
import com.example.demo1210.service.IExpressionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: Controller
 * @date: 2022-02-19
 */
@Slf4j
@RestController
@RequestMapping("expression")
public class ExpressionController {

    private final IExpressionService expressionServiceImpl;

    public ExpressionController(IExpressionService expressionServiceImpl) {
        this.expressionServiceImpl = expressionServiceImpl;
    }

    /**
     * 查询列表
     */
    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<List<Expression>> list(Integer id) {
        if (id == null) {
            //id=null查询所有
            return R.success(expressionServiceImpl.list());
        }
        //根据id查
        return R.success(expressionServiceImpl.listId(id));
    }

    /**
     * 添加或修改
     */
    @PostMapping(value = "addOrUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> addOrUpdate(@RequestBody Expression entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            Integer success = expressionServiceImpl.add(entity);
            ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
            resultSuccess.setSuccess(success);
            return R.success(resultSuccess);
        }
        Integer success = expressionServiceImpl.updateByE(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "delete")
    public R<ResultSuccess<Integer>> delete(@RequestBody Set<Integer> ids) {
        if (ids == null) {
            return R.fail400();
        }
        Integer success = expressionServiceImpl.deleteE(ids);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

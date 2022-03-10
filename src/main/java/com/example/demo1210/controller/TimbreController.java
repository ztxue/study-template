package com.example.demo1210.controller;


import com.example.demo1210.entity.Timbre;
import com.example.demo1210.result.R;
import com.example.demo1210.result.ResultSuccess;
import com.example.demo1210.service.ITimbreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: 音色（发言人）管理 Controller
 * @date: 2022-02-21
 */
@Slf4j
@RestController
@RequestMapping("timbre")
public class TimbreController {

    private final ITimbreService timbreServiceImpl;

    public TimbreController(ITimbreService timbreServiceImpl) {
        this.timbreServiceImpl = timbreServiceImpl;
    }

    /**
     * 查询列表
     */
    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<List<Timbre>> list(Integer id) {
        if (id == null){
            //id=null查询所有
            List<Timbre> timbreList = timbreServiceImpl.listTimbre();
            return R.success(timbreList);
        }
        //根据id查
        List<Timbre> timbreList = timbreServiceImpl.listById(id);
        return R.success(timbreList);

    }

    /**
     * 添加或修改
     */
    @PostMapping(value = "addOrUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> addOrUpdate(@RequestBody Timbre entity) {
        if (entity == null) {
            return R.fail400();
        }
        if (entity.getId() == null) {
            Integer success = timbreServiceImpl.add(entity);
            ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
            resultSuccess.setSuccess(success);
            return R.success(resultSuccess);
        }
        Integer success = timbreServiceImpl.update(entity);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<ResultSuccess<Integer>> delete(@RequestBody Set<Integer> ids) {
        if (ids == null) {
            return R.fail400();
        }
        Integer success = timbreServiceImpl.delete(ids);
        ResultSuccess<Integer> resultSuccess = new ResultSuccess<>();
        resultSuccess.setSuccess(success);
        return R.success(resultSuccess);
    }
}

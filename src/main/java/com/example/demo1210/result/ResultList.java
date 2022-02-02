package com.example.demo1210.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:列表返回
 * @date:2020/11/02
 */
@Setter
@Getter
public class ResultList<T> {
    /**
     * 列表
     */
    @JSONField(ordinal = 10)
    private List<T> list;
    /**
     * 分页信息
     */
    @JSONField(ordinal = 20)
    private PageBean page;
}

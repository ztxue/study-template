package com.example.demo1210.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1210.bean.SysAreaParams;
import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.entity.SysArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author: 张童学
 * @description: 区划信息 Mapper
 * @date: 2022-01-26
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysArea> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`code`" +
            " ,t.`name`" +
            " ,t.`parent_code`" +
            " ,t.`sort`" +
            " ,t.`deleted`" +
            " FROM sys_area t " +
            "<where>" +
            "</where>" +
            " ORDER BY t.id DESC" +
            "</script>")
    IPage<SysArea> selectExpressionList(@Param("params") SysAreaParams params, @Param("page") Page<SysArea> page);

    @Select("<script>" +
            " Select" +
            " code AS id" +
            ",name AS title" +
            ",parent_code AS parentId" +
            " From" +
            " sys_area " +
            "</script>")
    List<TreeNode> getTree();
}

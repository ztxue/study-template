package com.example.demo1210.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.entity.DPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/5 13:46
 * @describe
 */
@Mapper
public interface DPojoMapper extends BaseMapper<DPojo> {



    @Select("<script>" +
            " Select" +
            " id" +
            ",name AS title" +
            ",parent_id AS parentId" +
            " From" +
            " sys_dept " +
            "</script>")
    List<TreeNode> selectSymptomTreeNodeJson();

}

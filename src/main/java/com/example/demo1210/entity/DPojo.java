package com.example.demo1210.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门Tree结构
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dept")
public class DPojo implements Serializable {
 
    /**
     * id
     */
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    /**
     * 父Id
     */
    private Integer parentId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 删除标识
     */
    private String isDeleted;
    /**
     * 子节点
     */
    private List<DPojo> treeNode = new ArrayList<>();

}
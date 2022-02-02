package com.example.demo1210.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/4 11:19
 * @describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffBean {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("dept_id")
    private Integer deptId;

    @TableField("dept_name")
    private String deptName;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private Integer sex;

    @TableField("email")
    private String email;

    @TableField("tel")
    private String tel;

    @TableField("levels")
    private Integer levels;

    @TableField("address")
    private String address;

    @TableField("gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified",update="now()")
    private Date gmtModified;

    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
}

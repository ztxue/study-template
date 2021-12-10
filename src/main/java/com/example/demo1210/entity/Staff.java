package com.example.demo1210.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Getter
@Setter
@TableName("tb_staff")
@ApiModel(value = "Staff对象", description = "")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("部门ID")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty("部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("性别1表男,2表女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("级别,1234....")
    @TableField("levels")
    private Integer levels;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("创建时间")
    @TableField("gmt_create")
    private Date gmtCreate;

    @ApiModelProperty("修改时间")
    @TableField("gmt_modified")
    private Date gmtModified;

    @ApiModelProperty("逻辑删除,0存在,1删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


}

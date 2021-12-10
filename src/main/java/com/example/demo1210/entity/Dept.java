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
@TableName("tb_dept")
@ApiModel(value = "Dept对象", description = "")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("部门名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("等级")
    @TableField("levels")
    private Integer levels;

    @ApiModelProperty("联系人")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("联系电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("描述")
    @TableField("descr")
    private String descr;

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

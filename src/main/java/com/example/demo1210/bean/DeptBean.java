package com.example.demo1210.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张童学
 * @version 1.0
 * describe
 * @date 2021/12/13 17:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptBean {

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

}

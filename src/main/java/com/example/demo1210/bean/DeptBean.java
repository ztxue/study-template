package com.example.demo1210.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    private String name;

    @ApiModelProperty("等级")
    private Integer levels;

    @ApiModelProperty("联系人")
    private String userName;

    @ApiModelProperty("联系电话")
    private String tel;

    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}

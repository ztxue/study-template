package com.example.demo1210.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private BigInteger id;
    private String title;
    private BigInteger parentId;
    private List<TreeNode> children = new ArrayList<>();
}

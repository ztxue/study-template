package com.example.demo1210.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;
    private String title;
    private Integer parentId; 
    private List<TreeNode> children = new ArrayList<>();
}

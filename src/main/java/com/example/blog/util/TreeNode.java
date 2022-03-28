//package com.example.blog.util;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.Serializable;
//
///**
// * @author: sunping
// * @description: ztree节点封装类
// * @date: 2020/5/20
// */
//@Setter
//@Getter
//public class TreeNode implements Serializable {
//    /**
//     * 节点id
//     */
//    @JSONField(ordinal = 1)
//    private Object id;
//    /**
//     * 父节点id
//     */
//    @JSONField(ordinal = 2)
//    private Object parentId;
//    /**
//     * 节点code
//     */
//    @JSONField(ordinal = 3)
//    private String code;
//    /**
//     * 节点名称
//     */
//    @JSONField(ordinal = 4)
//    private String name;
//    /**
//     * 子节点数
//     */
//    @JSONField(serialize = false, ordinal = 5)
//    private Integer childrenCount;
//    /**
//     * 子节类型
//     */
//    @JSONField(ordinal = 6)
//    private Integer type;
//    /**
//     * 是否选中
//     */
//    @JSONField(ordinal = 7)
//    private Boolean checked;
//    /**
//     * 是否有子节点，有为true
//     */
//    @JSONField(ordinal = 8)
//    private Boolean isParent;
//    /**
//     * 子节点
//     */
//    @JSONField(ordinal = 8)
//    private Boolean isLeaf;
//    /**
//     * 是否展开,展开为true
//     */
//    @JSONField(ordinal = 9)
//    private String open;
//    /**
//     * 节点自定义图标的
//     */
//    @JSONField(ordinal = 10)
//    private String iconSkin;
//    /**
//     * 节点自定义图标的 URL 路径
//     */
//    @JSONField(ordinal = 11)
//    private String icon;
//    /**
//     * 父节点自定义展开时图标的 URL 路径
//     */
//    @JSONField(ordinal = 12)
//    private String iconOpen;
//    /**
//     * 父节点自定义折叠时图标的 URL 路径。
//     */
//    @JSONField(ordinal = 13)
//    private String iconClose;
//    /**
//     * 图标样式
//     */
//    @JSONField(ordinal = 14)
//    private String iconCls;
//
//
//}

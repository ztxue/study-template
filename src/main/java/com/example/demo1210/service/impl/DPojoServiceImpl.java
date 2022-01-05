package com.example.demo1210.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1210.bean.TreeNode;
import com.example.demo1210.entity.DPojo;
import com.example.demo1210.mapper.DPojoMapper;
import com.example.demo1210.service.DPojoService;
import com.example.demo1210.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/5 13:48
 * @describe
 */
@Service
public class DPojoServiceImpl extends ServiceImpl<DPojoMapper, DPojo> implements DPojoService {

    @Autowired
    DPojoMapper mapper;

    public List<TreeNode> getTree(){
        List<TreeNode> treeNodes = mapper.selectSymptomTreeNodeJson();

        return TreeUtil.build(treeNodes);
    }


    //生成树
    @Override
    public List<DPojo> getAllOneTwoSubject(int id) {

        List<DPojo> pojos = mapper.selectList(new QueryWrapper<DPojo>()
                .select("name", "id", "parent_id")
        );
        if (pojos == null || pojos.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedList<DPojo> dPojosLinked = new LinkedList<>();
        for (DPojo pojo : pojos) {
            if (pojo.getParentId() == 0) {
                dPojosLinked.add(pojo);
            }
        }
        for (DPojo dPojo : dPojosLinked) {
            dPojo.setTreeNode(getChild(dPojo.getId(), pojos));
        }

        return dPojosLinked;
    }
    //递归获取children节点
    private List<DPojo> getChild(Integer id, List<DPojo> pojos) {
        LinkedList<DPojo> dPojoLinkedList = new LinkedList<>();
        for (DPojo pojo : pojos) {
            if (id.equals(pojo.getParentId())) {
                dPojoLinkedList.add(pojo);
            }
        }
        // 递归退出条件
        if (dPojoLinkedList.isEmpty()) {
            return Collections.emptyList();
        }
        // 把子菜单的子菜单再递归循环一遍
        for (DPojo data : dPojoLinkedList) {
            data.setTreeNode(getChild(data.getId(), pojos));
        }
        return dPojoLinkedList;
    }
}

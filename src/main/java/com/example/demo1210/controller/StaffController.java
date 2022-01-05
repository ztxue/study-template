package com.example.demo1210.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.demo1210.entity.Staff;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.setDeptName("研发部");
        staff.setUserName("张三");

        //JAVA对象转JSON字符串
        String jsonString = JSON.toJSONString(staff);
        System.out.println("-----------" + jsonString + "------------");

        //JSON字符串转JSON对象
        String json = "{\"action\":\"add\",\"id\":\"1\",\"ordinal\":8,\"organUnitFullName\":\"testJSON\",\"parent\":\"0\",\"suborderNo\":\"58961\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println("-----------" + jsonObject + "------------");

        //JSON字符串转JAVA简单对象

    }
}

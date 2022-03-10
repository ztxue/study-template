package com.example.demo1210.se.esayexcel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.example.demo1210.entity.Dept;
import com.example.demo1210.service.impl.DeptServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Test01 {
    //生成模拟数据
    private static List<Student> initData() {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student data = new Student();
            data.setName("写入数据0" + i);
            data.setBirthday(new Date());
            data.setGender("男");
            students.add(data);
        }
        return students;
    }

    @Test
    public void simpleWrite() {
        List<Student> students = initData();
        /*
            String pathName 写入文件的路径
            Class head      写入文件的对象类型
            默认写入到07的xlsx中，如果想要写入xls，可以指定类型（待验证）
         */
        ExcelWriterBuilder workBook = EasyExcel.write("C:\\Users\\ztxue\\Desktop\\esayexcel.xlsx", Student2.class);

        // sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字
        workBook.sheet("测试数据表").doWrite(students);
        System.out.println("写入完成！");
    }


}

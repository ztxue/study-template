package com.example.blog.se.esayexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 基于lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生性别
     */
    private String gender;

    /**
     * 学生出生日期
     */
    private Date birthday;
    /**
     * id
     */
    private String id;

    public static void main(String[] args) {

        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("C:\\Users\\ztxue\\Desktop\\esayexcel.xlsx", Student.class, new StudentReadListener());

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();

    }

}

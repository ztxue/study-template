package com.example.blog.se.esayexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;


public class StudentReadListener extends AnalysisEventListener<Student> {
    // 每读一样，会调用该invoke方法一次
    @Override
    public void invoke(Student data, AnalysisContext context) {
        System.out.println("解析到一条数据：" + data);
    }

    // 全部读完之后，会调用该方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("全部解析完成");
    }
}

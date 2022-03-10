package com.example.demo1210.se.esayexcel;

import com.example.demo1210.entity.Dept;
import com.example.demo1210.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelTestController {

    @Autowired
    DeptServiceImpl deptService;

    @PostMapping(value = "/import")
    public void simpleRead() {

    }

    @GetMapping(value = "/export")
    public void writeExcel(HttpServletResponse response) {

    }

}

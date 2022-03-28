package com.example.blog.se.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/3/11 17:18
 * @describe io流
 */
public class test {
    String p = "C:\\Users\\ztxue\\Desktop\\syrobot-0.0.2-SNAPSHOT.jar";
    FileInputStream file;

    {
        try {
            file = new FileInputStream(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

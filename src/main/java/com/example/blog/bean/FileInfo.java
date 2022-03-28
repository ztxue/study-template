package com.example.blog.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: sunping
 * @description: 文件信息
 * @date: 2021/4/26
 */
@Setter
@Getter
public class FileInfo {
    /**
     * 原始名称
     */
    private String name;
    /**
     * 相对地址
     */
    private String filePath;
    /**
     * 文件url
     */
    private String url;

}

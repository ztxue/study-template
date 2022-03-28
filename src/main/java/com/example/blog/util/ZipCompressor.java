package com.example.blog.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: sunping
 * @description: 文件压缩zip
 * @date: 2020/5/20
 */
@Slf4j
public class ZipCompressor {
    static final int BUFFER = 8192;

    private final File zipFile;

    public ZipCompressor(String pathName) {
        zipFile = new File(pathName);
    }

    public void compress(String... pathName) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(zipFile); CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                new CRC32()); ZipOutputStream out = new ZipOutputStream(cos)) {
            String basedir = "";
            for (String s : pathName) {
                compress(new File(s), out, basedir);
            }
        } catch (IOException e) {
            log.error("压缩异常", e);
        }
    }

    public void compress(String srcPathName) {
        File file = new File(srcPathName);
        if (!file.exists()) {
            log.error(srcPathName + "不存在!");
            return;
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(zipFile); CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                new CRC32()); ZipOutputStream out = new ZipOutputStream(cos)) {
            String basedir = "";
            compress(file, out, basedir);
        } catch (IOException e) {
            log.error("压缩异常", e);
        }
    }

    private void compress(File file, ZipOutputStream out, String basedir) {
        /* 判断是目录还是文件 */
        if (file.isDirectory()) {
            this.compressDirectory(file, out, basedir);
        } else {
            this.compressFile(file, out, basedir);
        }
    }

    /**
     * 压缩一个目录
     */
    private void compressDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            /* 递归 */
            compress(file, out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 压缩一个文件
     */
    private void compressFile(File file, ZipOutputStream out, String basedir) {
        if (!file.exists()) {
            return;
        }
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file))) {
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            int count;
            byte[] data = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                out.write(data, 0, count);
            }
        } catch (IOException e) {
            log.error("压缩异常", e);
        }
    }

}

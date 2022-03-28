package com.example.blog.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: sunping
 * @description: 文件处理类
 * @date: 2020/5/20
 */
@Slf4j
public class FileTool {
    /**
     * 文件斜杠
     */
    public static final String FILE_SEPARATOR = "/";

    private FileTool() {
    }

    public static boolean copy(File src, File dst) {
        boolean result = false;

        try (InputStream in = new BufferedInputStream(new FileInputStream(src), 1024); OutputStream out = new BufferedOutputStream(new FileOutputStream(dst), 1024)) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public static boolean copy(File src, String dst) {

        File file = new File(dst);
        boolean result = false;
        try (InputStream in = new BufferedInputStream(new FileInputStream(src), 1024); OutputStream out = new BufferedOutputStream(new FileOutputStream(file), 1024)) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            result = true;
        } catch (Exception e) {
            log.error("500", e);
            result = false;
        }
        return result;
    }

    /**
     * 保存文件
     */
    public static boolean copyMultipartFile(MultipartFile src, String dst) {

        File file = new File(dst);
        boolean result = false;
        try (InputStream in = new BufferedInputStream(src.getInputStream(), 1024); OutputStream out = new BufferedOutputStream(new FileOutputStream(file), 1024)) {

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            result = true;
        } catch (Exception e) {
            log.error("500", e);
            result = false;
        }
        return result;
    }

    /**
     * 文件重命名
     */
    public static String getRename(MultipartFile file) {
        if (file == null) {
            return null;
        }
        //获取文件原名,并处理IE下兼容问题
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        int unixSep = fileName.lastIndexOf(File.separator);
        int winSep = fileName.lastIndexOf('\\');
        int pos = (Math.max(winSep, unixSep));
        if (pos != -1) {
            fileName = fileName.substring(pos + 1);
        }
        //随机生成UUID做文件名称
        String fid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀
        String postfix = fileName.substring(fileName.lastIndexOf('.'));
        //新名称

        return fid + postfix;

    }

    /**
     * 文件相对路径
     */
    public static String getFilePath(MultipartFile file, String targetPath) {
        return targetPath + getRename(file);

    }

    /**
     * 文件复制方法
     *
     * @param startPath  要读取的路径
     * @param outputPath 生成文件的输出路径
     * @param fileName   文件名称
     * @throws IOException 失败会抛出IO异常
     */
    public static void copyFile(String startPath, String outputPath, String fileName) throws IOException {
        File file = new File(outputPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileInputStreamPath = startPath + File.separator + fileName;
        String fileOutputStreamPath = outputPath + File.separator + fileName;
        try (FileInputStream ins = new FileInputStream(new File(fileInputStreamPath.replace("//", File.separator))); FileOutputStream out = new FileOutputStream(new File(fileOutputStreamPath.replace("//", File.separator)))) {
            byte[] b = new byte[1024];
            int n = 0;
            while ((n = ins.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (Exception e) {
            log.error("500", e);
        }

    }

    /**
     * 打包zip
     *
     * @param pid          pid
     * @param uploadFolder 文件系统目录
     * @param listFile     文件地址
     */
    public static String createZip(String pid, String uploadFolder, List<String> listFile) throws IOException {
        if (listFile == null || listFile.isEmpty()) {
            return null;
        }
        //创建zip目录
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String zipPath = "zip" + File.separator + sdf.format(new Date()) + File.separator + pid;
        File f = new File(uploadFolder + File.separator + zipPath);
        if ((!f.exists() && !f.isDirectory())) {
            f.mkdirs();
        }

        for (String url : listFile) {
            FileTool.copyFile(new File(uploadFolder + File.separator + url).getParent(), uploadFolder + File.separator + zipPath, url.substring(url.lastIndexOf(File.separator) + 1));
        }
        //zip压缩
        ZipCompressor zc = new ZipCompressor(uploadFolder + File.separator + zipPath + ".zip");
        zc.compress(uploadFolder + File.separator + zipPath);
        return zipPath + ".zip";
    }

    /**
     * 打包zip,带真实名称
     *
     * @param pid          pid
     * @param uploadFolder 文件系统目录
     * @param listFile     文件地址
     */
    public static String createZipByName(String pid, String uploadFolder, List<Map<String, String>> listFile) throws IOException {
        if (listFile == null || listFile.isEmpty()) {
            return null;
        }
        //创建zip目录
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String zipPath = "zip" + File.separator + sdf.format(new Date()) + File.separator + pid;
        File f = new File(uploadFolder + File.separator + zipPath);
        if ((!f.exists() && !f.isDirectory())) {
            f.mkdirs();
        }

        for (Map<String, String> map : listFile) {
            String url = map.get("url");
            String name = map.get("name");
            FileTool.copyFile(new File(uploadFolder + File.separator + url).getParent(), uploadFolder + File.separator + zipPath, url.substring(url.lastIndexOf(File.separator) + 1), name);
        }
        //zip压缩
        ZipCompressor zc = new ZipCompressor(uploadFolder + File.separator + zipPath + ".zip");
        zc.compress(uploadFolder + File.separator + zipPath);
        return zipPath + ".zip";
    }

    /**
     * 文件复制方法
     *
     * @param inputPath  要读取的路径
     * @param outputPath 生成文件的输出路径
     * @param inputName  文件名称
     * @param outputName 文件名称
     * @throws IOException 失败会抛出IO异常
     */
    public static void copyFile(String inputPath, String outputPath, String inputName, String outputName) throws IOException {
        File file = new File(outputPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileInputStreamPath = inputPath + File.separator + inputName;
        String fileOutputStreamPath = outputPath + File.separator + outputName;
        try (FileInputStream ins = new FileInputStream(new File(fileInputStreamPath.replace("//", File.separator))); FileOutputStream out = new FileOutputStream(new File(fileOutputStreamPath.replace("//", File.separator)))) {
            byte[] b = new byte[1024];
            int n = 0;
            while ((n = ins.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (Exception e) {
            log.error("500", e);
        }

    }

    /**
     * 字节数组保存为文件
     */
    public static void saveFile(byte[] bfile, String filePath) {
        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件传数组
     */
    public static byte[] fileToBytes(String filePath) {
        byte[] buffer = null;
        File file = new File(filePath);
        if (!file.exists()) {
            return buffer;
        }
        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}

package com.example.blog.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 佚名
 */
@SuppressWarnings("all")
public class ExportExcelUtils {
    private static final Logger logger = LoggerFactory.getLogger(ExportExcelUtils.class);

    /**
     * 导出Excel--数据源为list
     *
     * @param excelName 要导出的excel名称
     * @param list      要导出的数据集合
     * @param fieldMap  中英文字段对应Map，即要导出的excel表头
     * @param response  使用response可以导出到浏览器
     */
    public static <T> void exportList(String excelName, List<T> list, Map<String, String> fieldMap, HttpServletResponse response) {

        // 设置默认文件名为当前时间：年月日时分秒
        if (excelName == null || "".equals(excelName)) {
            excelName = new SimpleDateFormat("yyyyMMddhhmmss").format(
                    new Date());
        }
        // 设置response头信息
        response.reset();
        // 改成输出excel文件
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(excelName.getBytes("gb2312"), StandardCharsets.ISO_8859_1) + ".xls");
        } catch (UnsupportedEncodingException e1) {
            logger.info(e1.getMessage());
        }

        try {
            //创建一个WorkBook,对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //在Workbook中，创建一个sheet，对应Excel中的工作薄（sheet）
            HSSFSheet sheet = wb.createSheet(excelName);
            //创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            //创建一个居中格式
            style.setAlignment(CellStyle.ALIGN_CENTER);
            // 填充工作表
            fillSheet(sheet, list, fieldMap, style);

            //将文件输出
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            logger.info("导出Excel失败！");
            logger.error(e.getMessage());
        }
    }

    /**
     * 导出Excel--数据源为map
     *
     * @param excelName 要导出的excel名称
     * @param dataMap   要导出的数据集合
     * @param fieldMap  中英文字段对应Map，即要导出的excel表头
     * @param response  使用response可以导出到浏览器
     */
    public static void exportMap(String excelName, Map<String, List> dataMap, Map<String, LinkedHashMap<String, String>> fieldMap, HttpServletResponse response, HttpServletRequest request) {

        // 设置默认 文件名为当前时间：年月日时分秒
        if (excelName == null || "".equals(excelName)) {
            excelName = new SimpleDateFormat("yyyyMMddhhmmss").format(
                    new Date());
        }
        // 设置response头信息
        response.reset();
        // 改成输出excel文件
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(excelName.getBytes("gb2312"), StandardCharsets.ISO_8859_1) + ".xls");
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        } catch (UnsupportedEncodingException e1) {
            logger.info(e1.getMessage());
        }

        try {
            //创建一个WorkBook,对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();

            //多个 sheet
            for (int i = 0; i < fieldMap.size(); i++) {
                //在Workbook中，创建一个sheet，对应Excel中的工作薄（sheet）
                HSSFSheet sheet = wb.createSheet("sheet" + i);
                //创建单元格，并设置值表头 设置表头居中
                HSSFCellStyle style = wb.createCellStyle();
                //创建一个居中格式
                style.setAlignment(CellStyle.ALIGN_CENTER);
                // 填充工作表
                fillSheet(sheet, dataMap.get("sheet" + i), fieldMap.get("sheet" + i), style);

            }

            //将文件输出
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            logger.info("导出Excel失败！");
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据字段名获取字段对象
     *
     * @param fieldName 字段名
     * @param clazz     包含该字段的类
     * @return 字段
     */
    public static Field getFieldByName(String fieldName, Class<?> clazz) {
        logger.info("根据字段名获取字段对象:getFieldByName()");
        // 拿到本类的所有字段
        Field[] selfFields = clazz.getDeclaredFields();

        // 如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            //如果本类中存在该字段，则返回
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        // 否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            //递归
            return getFieldByName(fieldName, superClazz);
        }

        // 如果本类和父类都没有，则返回空
        return null;
    }

    /**
     * 根据字段名获取字段值
     *
     * @param fieldName 字段名
     * @param o         对象
     * @return 字段值
     * @throws Exception 异常
     */
    public static Object getFieldValueByName(String fieldName, Object o)
            throws Exception {

        logger.info("根据字段名获取字段值:getFieldValueByName()");
        Object value;
        //根据字段名得到字段对象
        Field field = getFieldByName(fieldName, o.getClass());

        //如果该字段存在，则取出该字段的值
        if (field != null) {
            //类中的成员变量为private,在类外边使用属性值，故必须进行此操作
            field.setAccessible(true);
            //获取当前对象中当前Field的value
            value = field.get(o);
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 "
                    + fieldName);
        }

        return value;
    }

    /**
     * 根据带路径或不带路径的属性名获取属性值,即接受简单属性名，
     * 如userName等，又接受带路径的属性名，如student.department.name等
     *
     * @param fieldNameSequence 带路径的属性名或简单属性名
     * @param o                 对象
     * @return 属性值
     * @throws Exception 异常
     */
    public static Object getFieldValueByNameSequence(String fieldNameSequence,
                                                     Object o) throws Exception {
        logger.info("根据带路径或不带路径的属性名获取属性值,即接受简单属性名:getFieldValueByNameSequence()");
        Object value;

        // 将fieldNameSequence进行拆分
        String[] attributes = fieldNameSequence.split("\\.");
        if (attributes.length == 1) {
            value = getFieldValueByName(fieldNameSequence, o);
        } else {
            // 根据数组中第一个连接属性名获取连接属性对象，如student.department.name
            Object fieldObj = getFieldValueByName(attributes[0], o);
            //截取除第一个属性名之后的路径
            String subFieldNameSequence = fieldNameSequence
                    .substring(fieldNameSequence.indexOf(".") + 1);
            //递归得到最终的属性对象的值
            value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
        }
        return value;

    }

    /**
     * 向工作表中填充数据
     *
     * @param sheet    excel的工作表名称
     * @param list     数据源
     * @param fieldMap 中英文字段对应关系的Map
     * @param style    表格中的格式
     * @throws Exception 异常
     */
    public static <T> void fillSheet(HSSFSheet sheet, List<T> list,
                                     Map<String, String> fieldMap, HSSFCellStyle style) throws Exception {
        logger.info("向工作表中填充数据:fillSheet()");
        // 定义存放英文字段名和中文字段名的数组
        String[] enFields = new String[fieldMap.size()];
        String[] cnFields = new String[fieldMap.size()];

        // 填充数组
        int count = 0;
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            enFields[count] = entry.getKey();
            cnFields[count] = entry.getValue();
            count++;
        }

        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);

        // 填充表头
        for (int i = 0; i < cnFields.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(cnFields[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        // 填充内容
        for (int index = 0; index < list.size(); index++) {
            row = sheet.createRow(index + 1);
            // 获取单个对象
            T item = list.get(index);
            for (int i = 0; i < enFields.length; i++) {
                Object objValue = getFieldValueByNameSequence(enFields[i], item);
                String fieldValue = objValue == null ? "" : objValue.toString();
                row.createCell(i).setCellValue(fieldValue);
            }
        }
    }


    /**
     * 解析Excel文件List
     */
    public static List<List<Object>> parseExcel(InputStream in, String fileName) throws Exception {
        List list = null;
        Workbook work = null;
        list = new ArrayList<>();
        //创建Excel工作薄
        work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    String value = "";
                    cell = row.getCell(y);
                    if (cell == null) {
                        continue;
                    }
                    int type = cell.getCellType();
                    if (y == 0 && type > 1) {
                        break;
                    }
                    try {
                        switch (cell.getCellType()) {
                            // 数字
                            case Cell.CELL_TYPE_NUMERIC:
                                //如果为时间格式的内容
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    value = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
                                    li.add(value);
                                    break;
                                } else {
                                    value = String.valueOf(cell.getNumericCellValue());
                                    String[] split = value.split("\\.");
                                    //整型不保留小数部分
                                    if (split[1].length() == 1 && "0".equals(split[1])) {
                                        value = split[0];
                                        li.add(value);
                                        break;
                                    }
                                    li.add(value);
                                    break;
                                }
                                // 字符串9
                            case Cell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                li.add(value);
                                break;
                            // Boolean
                            case Cell.CELL_TYPE_BOOLEAN:
                                value = cell.getBooleanCellValue() + "";
                                li.add(value);
                                break;
                            // 公式
                            case Cell.CELL_TYPE_FORMULA:
                                value = cell.getCellFormula() + "";
                                li.add(value);
                                break;
                            // 空值
                            case Cell.CELL_TYPE_BLANK:
                                value = "";
                                li.add(value);
                                break;
                            // 故障
                            case Cell.CELL_TYPE_ERROR:
                                value = "非法字符";
                                li.add(value);
                                break;
                            default:
                                value = "未知类型";
                                li.add(value);
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!li.isEmpty()) {
                    list.add(li);
                }
            }
            System.out.println("已处理：" + list.size() + " 行");
        }
        return list;

    }

    /**
     * 判断文件格式
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

}

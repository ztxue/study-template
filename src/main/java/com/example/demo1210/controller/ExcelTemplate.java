//package com.example.demo1210.controller;
//
//import lombok.SneakyThrows;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Set;
//
//import static java.nio.charset.StandardCharsets.ISO_8859_1;
//
///**
// * @author 张童学
// * @version 1.0
// * @date 2022/3/11 9:13
// * @describe
// */
//public class ExcelTemplate {
//    /**
//     * 导出Excel
//     */
//    @PostMapping(value = "export")
//    public void export(HttpServletResponse response, @RequestBody Set<Integer> ids) {
//        List<FunctionOption> dataList = new ArrayList<>();
//        //获取数据源
//        if (!ids.isEmpty()) {
//            //勾选即根据id查询数据
//            for (Integer id : ids) {
//                FunctionOption pojo = functionOptionServiceImpl.getById(id);
//                dataList.add(pojo);
//            }
//        } else {
//            //不勾选即查询所有数据
//            dataList = functionOptionServiceImpl.listNoPage();
//        }
//        //定义导出的excel名字
//        String excelName = "多媒体九宫格";
//        //获取需要转出的excel表头的map字段
//        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
//        fieldMap.put("id", "编号");
//        fieldMap.put("title", "标题");
//        fieldMap.put("robotCode", "机器人code");
//        fieldMap.put("icon", "图标地址");
//        fieldMap.put("background", "背景图地址");
//        fieldMap.put("isExistSecondaryMenu", "是否存在二级菜单");
//        fieldMap.put("contentType", "内容类型");
//        fieldMap.put("content", "内容");
//        fieldMap.put("parentId", "上级id");
//        ExportExcelUtils.exportList(excelName, dataList, fieldMap, response);
//
//    }
//
//    /**
//     * 导入Excel数据
//     */
//    @PostMapping(value = "input")
//    public R<Integer> input(@RequestParam("file") MultipartFile file) {
//        int input = functionOptionServiceImpl.input(file);
//        if (input == 0) {
//            return R.fail("插入失败");
//        }
//        return R.success(input);
//    }
//
//    /**
//     * 导入Excel
//     *
//     * @description: @SneakyThrows lombok注解，异常抛出
//     */
//    @SneakyThrows
//    @Override
//    public int input(MultipartFile file) {
//        //设置一个返回参数
//        int result = 0;
//        //list接收解析后的Excel
//        List<List<Object>> list;
//        if (!file.isEmpty()) {
//            //转成输入流
//            InputStream inputStream = file.getInputStream();
//            //解析Excel
//            list = ExportExcelUtils.parseExcel(inputStream, file.getOriginalFilename());
//            //关闭输入流
//            inputStream.close();
//            //遍历解析过的Excel，解构后插入数据库
//            for (List<Object> pojo : list) {
//                System.out.println("pojo ==" + pojo.toString());
//                //根据参数类赋值 提取数字和去除特殊符号(包括引号)
//                FunctionOptionParams entity = new FunctionOptionParams();
//                if (!"".equals(pojo.get(0))) {
//                    entity.setTitle(pojo.get(0).toString().replace("\"", ""));
//                }
//                if (!"".equals(pojo.get(1))) {
//                    entity.setRobotCode(pojo.get(1).toString().replace("\"", ""));
//                } else {
//                    //机器人编码不能空，为空则跳过本条数据插入
//                    continue;
//                }
//                if (!"".equals(pojo.get(2))) {
//                    entity.setIcon(pojo.get(2).toString().replace("\"", ""));
//                }
//                if (!"".equals(pojo.get(3))) {
//                    entity.setBackground(pojo.get(3).toString().replace("\"", ""));
//                }
//                if (!"".equals(pojo.get(4))) {
//                    entity.setIsExistSecondaryMenu(Integer.valueOf(pojo.get(4).toString().replace("\"", "")));
//                    //判断有无二级页面
//                    if (entity.getIsExistSecondaryMenu() == 0) {
//                        if (!"".equals(pojo.get(5))) {
//                            entity.setContentType(Integer.valueOf(pojo.get(5).toString().replace("\"", "")));
//                        }
//                        if (!"".equals(pojo.get(6))) {
//                            entity.setContent(pojo.get(6).toString().replace("\"", ""));
//                        }
//                    } else {
//                        //isExistSecondaryMenu = 1 即有二级页面,内容类型和内容两个字段就不用赋值
//                        entity.setContentType(null);
//                        entity.setContent(null);
//                    }
//                } else {
//                    //表格 “是否存在二级菜单”为空时,设置默认值
//                    entity.setIsExistSecondaryMenu(0);
//                    entity.setContentType(0);
//                    entity.setContent(null);
//                }
//                if (!"".equals(pojo.get(7))) {
//                    entity.setParentId(Integer.valueOf(pojo.get(7).toString().replace("\"", "")));
//                }
//                System.out.println("entity---" + entity);
//                //查重，有就更新，没有就插入
//                int check = functionOptionMapper.check(entity.getTitle(), entity.getParentId());
//                if (check > 0) {
//                    update(entity);
//                } else {
//                    add(entity);
//                }
//                result++;
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 下载Excel模板
//     */
//    @GetMapping("/upload")
//    public void upload(HttpServletResponse response) {
//        Workbook wb;
//        try {
//            ClassPathResource classPathResource = new ClassPathResource("template.xlsx");
//            InputStream inputStream = classPathResource.getInputStream();
//            // 根据不同excel创建不同对象,Excel2003版本-->HSSFWorkbook,Excel2007版本-->XSSFWorkbook
//            wb = WorkbookFactory.create(inputStream);
//            response.reset();
//            response.setContentType("multipart/form-data");
//            if ("HSSFWorkbook".equals(wb.getClass().getSimpleName())) {
//                response.setHeader("Content-Disposition",
//                        "attachment; filename=" + new String("Excel模板".getBytes(), ISO_8859_1) + ".xls");
//            } else {
//                response.setHeader("Content-Disposition",
//                        "attachment; filename=" + new String("Excel模板".getBytes(), ISO_8859_1) + ".xlsx");
//            }
//            wb.write(response.getOutputStream());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

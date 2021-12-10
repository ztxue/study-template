package com.example.demo1210;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class SpringbootMybatisPlus01ApplicationTests {
    // 代码自动生成器
    @Test
    public void main() {
        // 后面的全局配置 GlobalConfig 会用到projectPath，因此我这里先提取出来
        // 项目绝对路径，springboot-mybatis-plus01是我的springboot项目名
        // projectPath:
        // E:\MAVEN\springboot-application\springboot-mybatis-plus01
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_learning?&serverTimezone=Asia/Shanghai", "root", "342800")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("张童学")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)
                            // 指定输出目录
                            .outputDir(projectPath + "/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.example.demo1210")        // 设置父包名
//                            .moduleName("Learning")     // 父包模块名，默认值:无
                            // 上面两行代码加起来:com.IT.blog.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("service.impl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper"));
                })
                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {
                    builder.addInclude("tb_staff","tb_dept")                    // 增加表匹配，需要映射的数据库中的表名
                            .addTablePrefix("tb_")                 // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            .logicDeleteColumnName("is_deleted") // 逻辑删除字段名(数据库)
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
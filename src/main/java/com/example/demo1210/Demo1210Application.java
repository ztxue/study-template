package com.example.demo1210;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableCaching
@EnableTransactionManagement
@EnableOpenApi
@Slf4j
@SpringBootApplication
@MapperScan("com.example.demo1210.mapper")
public class Demo1210Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1210Application.class, args);
        log.info("==============》启动完成：8011");
    }

}

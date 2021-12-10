package com.example.demo1210;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@Slf4j
@SpringBootApplication
public class Demo1210Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1210Application.class, args);
        log.info("==============》启动完成：8080");
    }

}

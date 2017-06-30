package com.xieyunhai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xieyunhai.mapper")
public class QipeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QipeiApplication.class, args);
    }
}

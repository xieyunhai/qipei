package com.xieyunhai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.xieyunhai.mapper")
public class QipeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QipeiApplication.class, args);

//        String[] list = new String[]{"a", "b", "c"};
//        StringBuilder stringBuilder = new StringBuilder();
//        Arrays.stream(list).forEach(stringBuilder::append);
//        System.out.println(stringBuilder.toString());
    }
}

package com.yanfzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.yanfzh.mapper")
@SpringBootApplication
public class SpringBootWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebappApplication.class, args);
    }

}

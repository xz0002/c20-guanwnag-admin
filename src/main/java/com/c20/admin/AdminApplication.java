package com.c20.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-06 10:45
 */
@SpringBootApplication
@MapperScan("com.c20.admin.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}

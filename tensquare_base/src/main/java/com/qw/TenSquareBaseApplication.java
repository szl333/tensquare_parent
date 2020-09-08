package com.qw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Arkay
 * @Date 2020/9/7 15:32
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.qw.dao")
public class TenSquareBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(TenSquareBaseApplication.class, args);
    }
}

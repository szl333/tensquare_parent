package com.tensquare.qa;

import com.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author fxy
 * @date 2020/9/8 16:59
 */
@SpringBootApplication
@MapperScan("com.tensquare.qa.dao")
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    /**
     * 自定义ID生成器
     * */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }
}
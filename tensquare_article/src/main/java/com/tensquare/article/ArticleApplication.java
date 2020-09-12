package com.tensquare.article;

import com.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: ligangan
 * @Date: 2020/9/4
 * @Time: 22:14
 */
@SpringBootApplication
@MapperScan("com.tensquare.article.dao")
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }

    /**
     * 创建id生成器
     * @return
     */
    @Bean
    public IdWorker createIdWorker () {
        // 机器编号,序列号
        return new IdWorker(1,1);
    }
}

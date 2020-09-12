package com.qw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author Arkay
 * @Date 2020/9/9 15:26
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("qw")
                .apiInfo(apiInfo())
                .enable(true)
                .select().apis(RequestHandlerSelectors.basePackage("com.qw.controller"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基础模块测试")
                .description("基础模块包含两个方面，城市与标签")
                .version("开发")
                .build();
    }
}

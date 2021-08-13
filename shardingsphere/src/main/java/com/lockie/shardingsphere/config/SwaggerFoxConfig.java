/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import javax.swing.text.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**swagger-fox 配置
 * @author lvhaoguang
 * @date 2021-08-12 17:10
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerFoxConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.lockie.shardingsphere.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("ShardingSphere Demo")
            .description("Test shardingsphere and druid compatibility")
            .termsOfServiceUrl("http://127.0.0.1:8080/")
            .contact("xxx@163.com")
            .version("2.0")
            .build();
    }
}

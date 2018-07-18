package com.example.jedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/20
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Value( "${swaggerShow.show}" )
    private boolean swaggerShow;


    /**
     * 创建API基本信息
     * @return
     */
    @Bean
    public Docket createRestApi() {
        if(swaggerShow) {
            return new Docket( DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    //扫描需要展示的api接口
                    .apis( RequestHandlerSelectors.basePackage("com.example.jedis.controller"))
                    .paths( PathSelectors.any())
                    .build();
        }else {
            return new Docket( DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis( RequestHandlerSelectors.basePackage("cmo.00.00.0.0"))
                    .paths( PathSelectors.any())
                    .build();
        }

    }



    private ApiInfo apiInfo() {
        if(swaggerShow) {
            return new ApiInfoBuilder()
                    .title("Jedis项目开发阶段使用swagger查看接口")
                    .description("基于springBoot的整合开发")
                    .termsOfServiceUrl("http://www.baodu.com/")
                    .contact("wkn")
                    .version("1.0")
                    .build();
        }else {
            return new ApiInfoBuilder()
                    .title("项目生产阶段禁止使用swagger查看接口")
                    .description("基于springBoot的整合开发")
                    .termsOfServiceUrl("http://www.baodu.com/")
                    .contact("")
                    .version("")
                    .build();
        }

    }

}

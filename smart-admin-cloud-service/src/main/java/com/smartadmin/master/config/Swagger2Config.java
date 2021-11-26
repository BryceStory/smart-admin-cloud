package com.smartadmin.master.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Map;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/25
 */
@ConditionalOnProperty(name = "swagger.switch", havingValue = "ON", matchIfMissing = false)
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 分组名称
     */
    @Value("swagger.apiGroupName")
    private String apiGroupName;

    /**
     * 文档标题
     */
    @Value("swagger.title")
    private String title;

    /**
     * 文档描述
     */
    @Value("swagger.description")
    private String description;

    /**
     * api版本
     */
    @Value("swagger.api.version")
    private String version;

    /**
     * service url
     */
    @Value("swagger.serviceUrl")
    private String serviceUrl;

    /**
     * controller 包路径
     */
    @Value("swagger.base.package")
    private String basePackage;

    @Bean
    public Docket creatRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }


}

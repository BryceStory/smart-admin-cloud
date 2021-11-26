package com.smartadmin.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.smartadmin.master"})
public class SmartAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartAdminApplication.class, args);
        System.out.println("app start!!!");
    }
}

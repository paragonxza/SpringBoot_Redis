package com.gildata.xiza.demo.main;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description SpringBoot启动类
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
@SpringBootApplication(scanBasePackages = "com.gildata.xiza.demo")
@MapperScan(annotationClass = Mapper.class, basePackages = "com.gildata.xiza.demo")
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
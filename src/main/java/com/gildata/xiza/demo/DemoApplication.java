package com.gildata.xiza.demo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiza
 */
@SpringBootApplication(scanBasePackages = "com.gildata.xiza.demo")
@MapperScan(annotationClass = Mapper.class, basePackages = "com.gildata.xiza.demo")
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

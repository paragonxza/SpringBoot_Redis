package com.gildata.xiza.demo.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * @description Servlet初始化
 * @author xiza@gildata.comgon
 * @date 2021/3/8
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
        return application.sources(DemoApplication.class);
    }
}

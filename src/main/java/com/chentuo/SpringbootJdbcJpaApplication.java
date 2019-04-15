package com.chentuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootJdbcJpaApplication extends SpringBootServletInitializer {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJdbcJpaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootJdbcJpaApplication.class);
    }


}

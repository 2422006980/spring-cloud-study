package com.wc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan(basePackages = "com.wc.mapper")
public class DemoThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoThreadApplication.class, args);
	}

}

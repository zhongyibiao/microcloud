package com.xiaoweiyunchuang.microcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
//@EnableTransactionManagement
//@ServletComponentScan
//@EnableSwagger2
//@MapperScan("com.xiaoweiyunchuang.microcloud.mapper")
public class MicrocloudApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MicrocloudApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicrocloudApplication.class);
	}
}

package com.xiaoweiyunchuang.microcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//win环境配置(特别注意  在win环境下 路径最后一定要加“/”)
		String filePath = "file:///D:/Program Files/upload/files/";
		registry.addResourceHandler("/myimgs/**").addResourceLocations(filePath);
		
		//linux环境配置
	    //registry.addResourceHandler("/myimgs/**").addResourceLocations("file:////uploaded_files"); 
		 
		super.addResourceHandlers(registry);
	}

}
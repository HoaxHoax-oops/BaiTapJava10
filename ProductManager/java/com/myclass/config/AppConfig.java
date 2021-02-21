package com.myclass.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // chú thích đây là class config
@EnableWebMvc // cho phép sử dụng annotation
@ComponentScan( basePackages = "com.myclass.controller")
public class AppConfig implements WebMvcConfigurer{
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}

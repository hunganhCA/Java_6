package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.Interceptor.GolbalInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GolbalInterceptor golbal;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(golbal)
	.addPathPatterns("/**")
	.excludePathPatterns("/rest/**","/admin/**");
			
	}
	
}

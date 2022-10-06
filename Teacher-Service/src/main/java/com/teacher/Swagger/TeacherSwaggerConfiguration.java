package com.teacher.Swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class TeacherSwaggerConfiguration {
	@Bean
	 public Docket postApi() {
		 return new Docket(DocumentationType.SWAGGER_2).select()
				 .paths(PathSelectors.ant("/**"))
				 .apis(RequestHandlerSelectors.basePackage("com.teacher")).build()
				 .apiInfo(apiDetails());
	 }
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"School Management API",
				"Api for Schoool Mangement Project",
				"1.0",
				"free to use",
				new springfox.documentation.service.Contact("pardeep Nisha","http://pardeeppathak.io","a@b.com"),
				"API License",
				"http://javabrains.io",
				Collections.emptyList());
				
	}
}

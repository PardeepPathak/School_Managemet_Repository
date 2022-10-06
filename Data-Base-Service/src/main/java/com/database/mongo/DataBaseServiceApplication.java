package com.database.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataBaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseServiceApplication.class, args);
	}

}

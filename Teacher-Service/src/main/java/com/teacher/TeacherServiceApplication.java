package com.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.teacher.proxy.TeacherProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients ={TeacherProxy.class})
public class TeacherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherServiceApplication.class, args);
	}

}

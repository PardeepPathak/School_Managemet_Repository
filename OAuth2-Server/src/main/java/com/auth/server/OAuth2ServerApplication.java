package com.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.auth.server.proxy.RoleProxy;
import com.auth.server.proxy.StudentProxy;
import com.auth.server.proxy.TeacherProxy;
import com.auth.server.proxy.UserProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients ={StudentProxy.class,UserProxy.class,RoleProxy.class,TeacherProxy.class})
//@EnableOAuth2Sso
public class OAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}

}

package com.cloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.cloud.provider.mapper")
public class UserAppliction {

	public static void main(String[] args) {
		
		SpringApplication.run(UserAppliction.class, args);
	}

}

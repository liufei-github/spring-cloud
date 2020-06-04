package com.ht;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ht.dao")
public class ServiceEmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEmpApplication.class, args);
	}

}

package com.example.feignProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
@EnableConfigServer
public class FeignProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignProjectApplication.class, args);
	}

}

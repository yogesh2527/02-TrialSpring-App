package com.assimilate.springboot.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringBootSecurityDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDatabaseApplication.class, args);
	}

}

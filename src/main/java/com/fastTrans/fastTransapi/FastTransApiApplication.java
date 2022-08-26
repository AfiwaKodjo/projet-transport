package com.fastTrans.fastTransapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FastTransApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastTransApiApplication.class, args);
	}

}

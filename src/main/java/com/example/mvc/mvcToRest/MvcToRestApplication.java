package com.example.mvc.mvcToRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.mvc.controller")
public class MvcToRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcToRestApplication.class, args);
	}

}

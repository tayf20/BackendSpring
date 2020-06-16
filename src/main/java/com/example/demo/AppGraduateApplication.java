package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppGraduateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGraduateApplication.class, args);
	}
	@Bean
	public ModelMapper getModelmapper(){
		return new ModelMapper();
	}
}

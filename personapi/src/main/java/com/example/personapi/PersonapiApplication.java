package com.example.personapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonapiApplication {

	public static void main(String[] args) {
		// Starts the Spring Boot application
		SpringApplication.run(PersonapiApplication.class, args);
	}

	// @Bean tells Spring to manage the object returned by this method
	@Bean
    CommandLineRunner test() {
		// CommandLineRunner executes this code once after the Spring Boot application started
		return args -> {
			System.out.println("Application started");
		};
	}

}

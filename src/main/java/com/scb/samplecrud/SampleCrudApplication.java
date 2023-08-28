package com.scb.samplecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SampleCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi() {

		return new OpenAPI().components(new Components())
				.info(new Info().title("Spring Boot Rest APIs")
						.description("Springboot framework").version("1.0"));

	}
}

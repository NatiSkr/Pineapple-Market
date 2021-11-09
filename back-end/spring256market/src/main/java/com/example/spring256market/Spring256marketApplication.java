package com.example.spring256market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.example.spring256market"})
@EnableJpaRepositories(basePackages = { "com.example.spring256market"})
@EntityScan(basePackages = { "com.example.spring256market" })

@EnableAutoConfiguration

public class Spring256marketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring256marketApplication.class, args);
	}

}

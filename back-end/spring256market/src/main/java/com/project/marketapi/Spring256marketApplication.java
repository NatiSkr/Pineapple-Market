package com.project.marketapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.project.marketapi"})
@EnableJpaRepositories(basePackages = { "com.project.marketapi"})
@EntityScan(basePackages = { "com.project.marketapi" })

@EnableAutoConfiguration

public class Spring256marketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring256marketApplication.class, args);
	}

}

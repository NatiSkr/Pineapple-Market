package com.project.marketapi;

import javax.annotation.PostConstruct;

import com.project.marketapi.model.ERole;
import com.project.marketapi.model.Role;
import com.project.marketapi.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = { "com.project.marketapi"})
@EnableJpaRepositories(basePackages = { "com.project.marketapi"})
@EntityScan(basePackages = { "com.project.marketapi" })

@EnableAutoConfiguration

public class Spring256marketApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring256marketApplication.class, args);
	}

	@Component
	public class PostConstructExampleBean {

		@Autowired
		private RoleRepository roleRepository;

		@PostConstruct
		public void init() {
			Role adminRole = new Role();
			adminRole.setName(ERole.ROLE_ADMIN);
			roleRepository.save(adminRole);

			Role userRole = new Role();
			userRole.setName(ERole.ROLE_USER);
			roleRepository.save(userRole);
		}
	}
}

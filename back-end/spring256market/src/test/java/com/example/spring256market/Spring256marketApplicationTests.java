package com.example.spring256market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import com.project.marketapi.Spring256marketApplication;
<<<<<<< Updated upstream
import com.project.marketapi.model.Users;
import com.project.marketapi.repository.UsersRepository;
import com.project.marketapi.services.UsersService;
=======
import com.project.marketapi.model.Categories;
import com.project.marketapi.model.User;
import com.project.marketapi.repository.CategoriesRepository;
import com.project.marketapi.repository.UserRepository;
>>>>>>> Stashed changes

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Spring256marketApplication.class)
public class Spring256marketApplicationTests {

	@Autowired
<<<<<<< Updated upstream
	private UsersRepository usersRepository;

	@Autowired UsersService usersService;
=======
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
>>>>>>> Stashed changes

	// Insert an admin user
	@Test
	public void createUserRowAdmin() {
		User testUserJean = new User();
		testUserJean.setFirstName("Jean Luc");
		testUserJean.setLastNameM("Gessard");
		testUserJean.setLastNameP("Picard");
<<<<<<< Updated upstream
		testUserJean.setEmail("jl.picard@enterprise.com");
		testUserJean.setPassWord("Prime1Directive");
=======
		testUserJean.setUsername("admin@market.com");
		testUserJean.setPassword(encoder.encode("admin"));
>>>>>>> Stashed changes
		testUserJean.setCreationDate(new Date());
		User testReturnJean = userRepository.save(testUserJean);
		assertTrue(testReturnJean.getFirstName().equals(testUserJean.getFirstName()));
	}

	// Insert a regular user
	@Test
	public void createUserRowRegular() {
		User testUserWill = new User();
		testUserWill.setFirstName("William");
		testUserWill.setLastNameP("Riker");
<<<<<<< Updated upstream
		testUserWill.setEmail("w.riker@starfleet.com");
		testUserWill.setPassWord("rhysa");
=======
		testUserWill.setUsername("regular@market.com");
		testUserWill.setPassword(encoder.encode("regular"));
>>>>>>> Stashed changes
		testUserWill.setCreationDate(new Date());
		User testReturnWill = userRepository.save(testUserWill);
		assertTrue(testReturnWill.getPassword().equals(testUserWill.getPassword()));
	}

}

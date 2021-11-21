package com.example.spring256market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import com.project.marketapi.Spring256marketApplication;
import com.project.marketapi.model.Categories;
import com.project.marketapi.model.User;
import com.project.marketapi.repository.CategoriesRepository;
import com.project.marketapi.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest(classes = Spring256marketApplication.class)
public class Spring256marketApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// Insert an admin user
	@Test
	public void createUserRowAdmin() {
		User testUserJean = new User();
		testUserJean.setFirstName("Jean Luc");
		testUserJean.setLastNameM("Gessard");
		testUserJean.setLastNameP("Picard");
		testUserJean.setUsername("admin@market.com");
		testUserJean.setPassword(encoder.encode("admin"));
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
		testUserWill.setUsername("regular@market.com");
		testUserWill.setPassword(encoder.encode("regular"));
		testUserWill.setCreationDate(new Date());
		User testReturnWill = userRepository.save(testUserWill);
		assertTrue(testReturnWill.getPassword().equals(testUserWill.getPassword()));
	}

	// Insert a category
	@Autowired
	private CategoriesRepository categoriesRepository;

	@Test
	public void createDrinksRow() {
		Categories testCategoryDrinks = new Categories();
		testCategoryDrinks.setCategoryName("Drinks");
		Categories testReturnDrinks = categoriesRepository.save(testCategoryDrinks);
		assertTrue(testReturnDrinks.getCategoryName().equals(testCategoryDrinks.getCategoryName()));
	}

}
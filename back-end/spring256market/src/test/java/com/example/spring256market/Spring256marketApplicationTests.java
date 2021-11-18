package com.example.spring256market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import com.project.marketapi.Spring256marketApplication;
import com.project.marketapi.model.Categories;
import com.project.marketapi.model.Users;
import com.project.marketapi.repository.CategoriesRepository;
import com.project.marketapi.repository.UsersRepository;
import com.project.marketapi.services.UsersService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest(classes = Spring256marketApplication.class)
public class Spring256marketApplicationTests {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	UsersService usersService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// Insert an admin user
	@Test
	public void createUsersRowAdmin() {
		Users testUserJean = new Users();
		testUserJean.setIsAdmin(true);
		testUserJean.setFirstName("Jean Luc");
		testUserJean.setLastNameM("Gessard");
		testUserJean.setLastNameP("Picard");
		testUserJean.setEmail("admin@market.com");
		testUserJean.setPassWord(encoder.encode("admin"));
		testUserJean.setCreationDate(new Date());
		Users testReturnJean = usersRepository.save(testUserJean);
		assertTrue(testReturnJean.getFirstName().equals(testUserJean.getFirstName()));
	}

	// Insert a regular user
	@Test
	public void createUsersRowRegular() {
		Users testUserWill = new Users();
		testUserWill.setIsAdmin(false);
		testUserWill.setFirstName("William");
		testUserWill.setLastNameP("Riker");
		testUserWill.setEmail("regular@market.com");
		testUserWill.setPassWord(encoder.encode("regular"));
		testUserWill.setCreationDate(new Date());
		Users testReturnWill = usersRepository.save(testUserWill);
		assertTrue(testReturnWill.getPassWord().equals(testUserWill.getPassWord()));
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
package com.example.spring256market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.marketapi.Spring256marketApplication;
import com.project.marketapi.model.Categories;
import com.project.marketapi.repository.CategoriesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = Spring256marketApplication.class)
public class Spring256marketApplicationTests {

	// Insert a category
	@Autowired
	private CategoriesRepository categoriesRepository;

	@Test
	public void createFruitsRow() {
		Categories testCategoryDrinks = new Categories();
		testCategoryDrinks.setCategoryName("Fruits");
		Categories testReturnDrinks = categoriesRepository.save(testCategoryDrinks);
		assertTrue(testReturnDrinks.getCategoryName().equals(testCategoryDrinks.getCategoryName()));
	}

}
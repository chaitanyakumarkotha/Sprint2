package com.cg.GreatOutdoors.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.service.IProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {
	
	@Autowired
	IProductService productService;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All Test Cases started");
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");	
	}
	
	@AfterAll
	static void setUpAfterClass() {
		System.out.println("All test cases ended.");
	}

	@Test
	@DisplayName("Test for adding an product")
	public void addProductTest() throws ProductException
	{
		Product product=new Product(200,"Red","15cm","EnglishWillo","Kashmir",10,2,"Bat");
		assertEquals(true,productService.create(product));
	}
	
	@Test
	@DisplayName("Test for retrieving products")
	public void retrieveProductTest() throws ProductException
	{
		List<Product> list=productService.retrive();
		assertFalse(list.isEmpty());
	}
	
	@Test
	@DisplayName("Test for retrieving products by id")
	public void retrieveProductByIdTest() throws ProductException
	{
		Product product=productService.findById(4);
		assertNotNull(product);	
		
	Assertions.assertThrows(ProductException.class,()->{
			productService.findById(99);
		});
	}
}

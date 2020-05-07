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
import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IWishlistProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WishlistServiceTest {
	@Autowired
	IWishlistProductService wishlistProductService;
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
	@DisplayName("Test for adding an product in wishlist")
	public void addWishlistProductTest() throws ProductException
	{
		WishlistProduct product=new WishlistProduct(5);
		assertEquals(true,wishlistProductService.create(product));
	}
	
	@Test
	@DisplayName("Test for retrieving wishlist products")
	public void retrieveWishlistProductTest() throws ProductException
	{
		List<Product> list=wishlistProductService.retrive(1);
		assertFalse(list.isEmpty());
	}
	
	@Test
	@DisplayName("Test for checking an product in wishlist")
	public void CheckWishlistProductTest() throws ProductException
	{	 assertEquals(false,wishlistProductService.checkId(2,3));
     Assertions.assertThrows(ProductException.class,()->{
    	 wishlistProductService.checkId(1,3);});
    
	}
	
	@Test
	@DisplayName("Test for deleting the product from wishlist")
	public void deleteProductFromWishlistTest() throws  ProductException
	{
		
		assertEquals(true,wishlistProductService.deleteProduct(1,3 ));

		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(65,656 );
		});
		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(1,656 );
		});
		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(65,6 );
		});
		
		
		
	}

}

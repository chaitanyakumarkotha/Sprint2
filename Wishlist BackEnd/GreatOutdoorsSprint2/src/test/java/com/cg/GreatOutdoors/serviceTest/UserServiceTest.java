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
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
	@Autowired
	IUserService userService;

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
	@DisplayName("Test for adding an user")
	public void addUserTest() throws UserException {
		User user = new User("pass123", "retailer", "9090229222", "xyz@abc.com");
		assertEquals(true, userService.create(user));
	}
	
	@Test
	@DisplayName("Test for retrieving users")
	public void retrieveUserTest() throws  UserException
	{
		List<User> list=userService.retrive();
		assertFalse(list.isEmpty());
	}
	
	@Test
	@DisplayName("Test for retrieving user by id")
	public void retrieveUserByIdTest() throws  UserException
	{
		User user=userService.findById(1);
		assertNotNull(user);
		Assertions.assertThrows(UserException.class,()->{
			userService.findById(99);
		});
	}
		

}

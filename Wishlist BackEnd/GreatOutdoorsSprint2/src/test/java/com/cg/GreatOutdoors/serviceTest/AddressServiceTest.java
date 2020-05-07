package com.cg.GreatOutdoors.serviceTest;

import static org.junit.Assert.assertEquals;

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

import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.exception.AddressException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IAddressService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class AddressServiceTest {

	@Autowired
	IAddressService addressService;
	
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
	@DisplayName("Test for adding an address")
	public void addAddressTest() throws AddressException
	{
		Address address=new Address("R101","12","Gwalior","MP","Phoolbhag","144401");
		assertEquals(true,addressService.create(address, 1));
		Assertions.assertThrows(AddressException.class,()->{
			addressService.create(address, 99);
		});
		
	}
}

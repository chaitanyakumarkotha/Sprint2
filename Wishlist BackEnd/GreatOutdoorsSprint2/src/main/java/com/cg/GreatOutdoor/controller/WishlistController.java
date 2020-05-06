package com.cg.GreatOutdoor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.exception.AddressException;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IAddressService;
import com.cg.GreatOutdoor.service.IAllProductService;
import com.cg.GreatOutdoor.service.IProductService;
import com.cg.GreatOutdoor.service.IUserService;
@CrossOrigin(origins="*")
@RestController
public class WishlistController {
	@Autowired
	private IAllProductService allProductService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;
 
	@Autowired
	private IAddressService addressService;
	
	
	//*********************** ALL PRODUCTS OPERATION*********************************
	/*
	 * This methods is used to insert Product data in database . It takes the data only in json Format 
	 */
	@PostMapping(value="/addnewproduct",consumes="application/json")
	public String addProduct(@RequestBody AllProducts product) throws ProductException
	{   allProductService.create(product);
		return "Product Added Successfully";
	}
	
	
	/*
	 * This method will return the List of all the products available in database
     */
	@GetMapping(value="/allproduct/59")
	public List displayAllProducts() throws ProductException
	{  
		return allProductService.retrive();
	}
	
	/*
	 * This method will return the details of Particular Product 
	 */
	@GetMapping(value="/product/{id}")
	public AllProducts productById(@PathVariable Long id) throws ProductException 
	{
	        AllProducts product=allProductService.findById(id);
	    	 return product;
		   
	}
	///////////////////////////////////////////////////////////////////////
	
	
	//********************USER OPERATION**************************
	/*
	 * This method will create the new user. It takes the data in Json Format
	 */
	
	@PostMapping(value="/addUser",consumes="application/json")
	public String addUser(@RequestBody User user) throws UserException
	{
		Address address=new Address("R101","15","Gwalior","MP","phoolbhag","144411");
		user.addAddress(address);
		userService.create(user);
		
		return "User Added Successfully";
	}
	
	/*
	 * This method will return the List of all user saved in database
	 */
	
	
	@PostMapping(value="/addAddress/{userId}",consumes="application/json")
	public String addAddress(@RequestBody Address address , @PathVariable long userId) throws UserException, AddressException
	{
		
		
		addressService.create(address,userId);
		
		return "User Added Successfully";
	}
	
   @GetMapping(value="/alluser")
   public List<User> displayAllUser() throws UserException
   {
	   return userService.retrive();
   }
   
   /*
    * This method will return a user with Particular userId
    */
   @GetMapping(value="/user/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
   public User userById(@PathVariable Long userId) throws UserException
   {  
	   System.out.println(userService.findById(userId));
	   return userService.findById(userId);
   }
 //////////////////////////////////////////////////////////////////////////////
   
  //*********Wishlist Operation***************
   
   /*
    * This method will like the product with respective user and save it to the wishlist.
    */
   
   @GetMapping(value="/user/59/{productId}")
   public void addToWislist(@PathVariable long productId) throws ProductException, UserException
   {   long userId=59;
	   System.out.println("UID= "+userId+" PID= "+productId);
	    if(productService.checkId(userId, productId))
	    {
	    	Product product=new Product(productId);
	    	product.setUser(userService.findById(userId));
	    	productService.create(product);
	    }  
	    
   }
   
   /*
    * This method will delete the particular Product from wishlist with respect to the particular user.
    */
   @DeleteMapping(value="/user/59/{productId}")
   public void deleteProduct( @PathVariable long productId) throws ProductException
   {   long userId = 59;
	   productService.deleteProduct(userId, productId);
	   System.out.println("Prodcut Deleted from Wishlist");
   }
   
   /*
    * This method will return List of Product Liked by the particular user
    */
   
   @GetMapping(value="/wishlistproduct/59")
	public List fetchProduct() throws ProductException
	{  System.out.println("inside controller");
	    long userId=59;
	    return productService.retrive(userId);
	}
  
   
   
   
   
   ///////////////////////////////////////////

}

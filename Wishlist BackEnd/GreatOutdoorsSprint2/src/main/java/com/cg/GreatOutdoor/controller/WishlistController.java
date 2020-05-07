package com.cg.GreatOutdoor.controller;

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
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.exception.AddressException;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IAddressService;
import com.cg.GreatOutdoor.service.IProductService;
import com.cg.GreatOutdoor.service.IWishlistProductService;
import com.cg.GreatOutdoor.service.IUserService;
@CrossOrigin(origins="*")
@RestController
public class WishlistController {
	@Autowired
	private IProductService ProductService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IWishlistProductService wishlistProductService;
 
	@Autowired
	private IAddressService addressService;
	
	
	//*********************** ALL PRODUCTS OPERATION*********************************
	/*
	 * This methods is used to insert Product data in database . It takes the data only in json Format 
	 */
	@PostMapping(value="/product",consumes="application/json")
	public String addProduct(@RequestBody Product product) throws ProductException
	{   ProductService.create(product);
		return "Product Added Successfully";
	}
	
	
	/*
	 * This method will return the List of all the products available in database
     */
	@GetMapping(value="/product")
	public List displayAllProducts() throws ProductException
	{  
		return ProductService.retrive();
	}
	
	/*
	 * This method will return the details of Particular Product 
	 */
	@GetMapping(value="/product/{id}")
	public Product productById(@PathVariable Long id) throws ProductException 
	{
	        Product product=ProductService.findById(id);
	    	 return product;
		   
	}
	///////////////////////////////////////////////////////////////////////
	
	
	//********************USER OPERATION**************************
	/*
	 * This method will create the new user. It takes the data in Json Format
	 */
	
	@PostMapping(value="/user",consumes="application/json")
	public String addUser(@RequestBody User user) throws UserException
	{

		userService.create(user);
		
		return "User Added Successfully";
	}
	
	/*
	 * This method will return the List of all user saved in database
	 */
	
	
	@PostMapping(value="/address/{userId}",consumes="application/json")
	public String addAddress(@RequestBody Address address , @PathVariable long userId) throws UserException, AddressException
	{
		
		
		addressService.create(address,userId);
		
		return "User Added Successfully";
	}
	
   @GetMapping(value="/user")
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
   
   @GetMapping(value="/user/{userId}/{productId}")
   public void addToWislist(@PathVariable long userId,@PathVariable long productId) throws ProductException, UserException
   {   
	    if(!wishlistProductService.checkId(userId, productId))
	    {
	    	WishlistProduct product=new WishlistProduct(productId);
	    	product.setUser(userService.findById(userId));
	    	wishlistProductService.create(product);
	    }  
	    
   }
   
   /*
    * This method will delete the particular Product from wishlist with respect to the particular user.
    */
   @DeleteMapping(value="/user/{userId}/{productId}")
   public void deleteProduct(@PathVariable long userId,@PathVariable long productId) throws ProductException
   {   
	   wishlistProductService.deleteProduct(userId, productId);
	 
   }
   
   /*
    * This method will return List of Product Liked by the particular user
    */
   
   @GetMapping(value="/wishlistproduct/{userId}")
	public List fetchProduct(@PathVariable long userId) throws ProductException
	{  
	    
	    return wishlistProductService.retrive(userId);
	}
  
   
   
   
   
   ///////////////////////////////////////////

}

package com.cg.GreatOutdoor.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.exception.ProductException;



public interface IProductDao {

	public void create(Product product);
	public List retrive(long userId);
	public boolean checkId(long userId, long productId) throws ProductException;
	public void deleteProduct(long userId, long productId);
	
}

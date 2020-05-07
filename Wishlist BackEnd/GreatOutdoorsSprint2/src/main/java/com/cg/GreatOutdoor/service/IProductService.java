package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.exception.ProductException;


public interface IProductService {
	public boolean create(Product product) throws ProductException;
	public List<Product> retrive() throws ProductException;
	public Product findById(long id) throws ProductException;
}

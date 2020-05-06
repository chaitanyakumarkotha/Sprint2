package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.exception.ProductException;

public interface IProductService {
	public void create(Product product) throws ProductException;
	public List retrive(long userId) throws ProductException;
	public boolean checkId(long userId, long productId) throws ProductException;
	public void deleteProduct(long userId, long productId) throws ProductException;
}

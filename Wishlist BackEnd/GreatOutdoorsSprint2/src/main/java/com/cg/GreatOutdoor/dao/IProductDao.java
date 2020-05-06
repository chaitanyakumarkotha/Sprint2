package com.cg.GreatOutdoor.dao;

import java.util.List;

import com.cg.GreatOutdoor.entity.Product;


public interface IProductDao {
	public void create(Product product);
	public List<Product> retrive();
	public Product findById(long id);
	public boolean checkProductId(long productId);
}

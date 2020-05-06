package com.cg.GreatOutdoor.dao;

import java.util.List;

import com.cg.GreatOutdoor.entity.AllProducts;


public interface IAllProductDao {
	public void create(AllProducts product);
	public List retrive();
	public AllProducts findById(long id);
	public boolean checkProductId(long productId);
}

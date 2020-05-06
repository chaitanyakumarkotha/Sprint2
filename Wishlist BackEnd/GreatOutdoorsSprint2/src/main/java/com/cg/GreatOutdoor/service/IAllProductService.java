package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.exception.ProductException;


public interface IAllProductService {
	public void create(AllProducts product) throws ProductException;
	public List retrive() throws ProductException;
	public AllProducts findById(long id) throws ProductException;
}

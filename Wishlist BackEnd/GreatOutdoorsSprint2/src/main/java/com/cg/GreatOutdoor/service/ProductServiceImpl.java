package com.cg.GreatOutdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.GreatOutdoor.dao.IProductDao;
import com.cg.GreatOutdoor.entity.Product;

import com.cg.GreatOutdoor.exception.ProductException;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao allProductDao;

	@Override
	public void create(Product product) throws ProductException {

		try {
			allProductDao.create(product);
		} catch (Exception e) {
			throw new ProductException("Product not saved successfully");
		}
	}

	@Override
	public List<Product> retrive() throws ProductException {

		List<Product> productList = allProductDao.retrive();
		if (productList.size() == 0) {
			throw new ProductException("Product List is Empty");
		} else {
			return productList;
		}

	}

	@Override
	public Product findById(long id) throws ProductException {

		Product product = allProductDao.findById(id);
		if (product == null) {
			throw new ProductException("Product not found");
		} else {
			return product;
		}
	}

}

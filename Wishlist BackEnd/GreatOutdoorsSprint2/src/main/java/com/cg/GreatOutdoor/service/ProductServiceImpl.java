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
	private IProductDao productDao;

	@Override
	public boolean create(Product product) throws ProductException {

		boolean status=productDao.create(product);
		if(status)
			return true;
		else
			return false;
	}

	@Override
	public List<Product> retrive() throws ProductException {

		List<Product> productList =productDao.retrive();
		if (productList.isEmpty()) {
			throw new ProductException("Product List is Empty");
		} else {
			return productList;
		}

	}

	@Override
	public Product findById(long id) throws ProductException {

		Product product = productDao.findById(id);
		if (product == null) {
			throw new ProductException("Product not found");
		} else {
			return product;
		}
	}

}

package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;

public interface IWishlistProductService {
	public void create(WishlistProduct product) throws ProductException;
	public List<Product> retrive(long userId) throws ProductException;
	public boolean checkId(long userId, long productId) throws ProductException;
	public void deleteProduct(long userId, long productId) throws ProductException;
}

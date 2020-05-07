package com.cg.GreatOutdoor.dao;

import java.util.List;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;

public interface IWishlistProductDao {

	public boolean create(WishlistProduct product);

	public List<Product> retrive(long userId);

	public boolean checkId(long userId, long productId) throws ProductException;

	public boolean deleteProduct(long userId, long productId);

}

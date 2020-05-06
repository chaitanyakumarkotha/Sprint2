package com.cg.GreatOutdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.GreatOutdoor.dao.IWishlistProductDao;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;

@Service
public class WishlistProductServiceImpl implements IWishlistProductService {

	@Autowired
	private IWishlistProductDao productDao;

	@Override
	public void create(WishlistProduct product) throws ProductException {

		try {
			productDao.create(product);
		} catch (Exception exception) {
			throw new ProductException("Unable to insert in wishlist");
		}
	}

	@Override
	public List<Product> retrive(long userId) throws ProductException {

		List<Product> ProductList = productDao.retrive(userId);
		if (ProductList.isEmpty()) {
			throw new ProductException("Wishlist is empty");
		} else {
			return ProductList;
		}
	}

	@Override
	public boolean checkId(long userId, long productId) throws ProductException {

		boolean result = productDao.checkId(userId, productId);
		if (result) {
			return true;
		} else {

			throw new ProductException("UserId or ProductId is not valid");
		}
	}

	@Override
	public void deleteProduct(long userId, long productId) throws ProductException {

		try {
			productDao.deleteProduct(userId, productId);
		} catch (Exception exception) {
			throw new ProductException("Not able to delete Product");
		}
	}

}

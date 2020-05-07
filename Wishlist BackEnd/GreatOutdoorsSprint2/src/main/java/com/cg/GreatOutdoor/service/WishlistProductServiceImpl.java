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
	private IWishlistProductDao wishlistProductDao;

	@Override
	public boolean create(WishlistProduct product) throws ProductException {
        boolean status=wishlistProductDao.create(product);
		if(status)
		{
			return true;
		}
		else
		{
			throw new ProductException("Unable to insert in wishlist");
		}
	}

	@Override
	public List<Product> retrive(long userId) throws ProductException {

		List<Product> ProductList = wishlistProductDao.retrive(userId);
		if (ProductList.isEmpty()) {
			throw new ProductException("Wishlist is empty");
		} else {
			return ProductList;
		}
	}

	@Override
	public boolean checkId(long userId, long productId) throws ProductException {

		boolean result = wishlistProductDao.checkId(userId, productId);
		if (result) {
			throw new ProductException("PoductId already exist in wishlist");

		} else {
			return false;

		}
	}

	@Override
	public boolean deleteProduct(long userId, long productId) throws ProductException {

		 boolean status=wishlistProductDao.deleteProduct(userId, productId);
		 if(status)
		 {
			 return true;
		 }
		 else
		 {
			 System.out.println("last");
			 throw new ProductException("Not able to delete Product"); 
		 }
	
	}	

}

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
	public void create(Product product) throws ProductException{
		// TODO Auto-generated method stub
		try {
       productDao.create(product);
		}
		catch(Exception exception)
		{
			throw new ProductException("Unable to insert in wishlist");
		}
	}

	@Override
	public List retrive(long userId) throws ProductException {
		// TODO Auto-generated method stub
		System.out.println("inside product service");
		List<Product> wishlistProductList=productDao.retrive(userId);
		if(wishlistProductList.size()== 0)
		{
			throw new ProductException("Wishlist is empty");
		}
		else
		{
			return wishlistProductList;
		}
	}

	@Override
	public boolean checkId(long userId, long productId) throws ProductException
	{
		System.out.println("IN PRODUCT SERVICE        UID= "+userId+" PID= "+productId);
		boolean result=productDao.checkId(userId, productId);
		if(result)
		{
			return true;
		}
		else {
			
		   throw new ProductException("UserId or ProductId is not valid");
		}
    }

	@Override
	public void deleteProduct(long userId, long productId) throws ProductException {
		// TODO Auto-generated method stub
		try {
		productDao.deleteProduct(userId, productId);
		}
		catch(Exception exception)
		{
			throw new ProductException("Not able to delete Product");
		}
	}

	
}

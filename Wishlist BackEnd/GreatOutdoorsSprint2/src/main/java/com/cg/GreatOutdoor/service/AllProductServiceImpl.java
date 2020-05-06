package com.cg.GreatOutdoor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.GreatOutdoor.dao.IAllProductDao;
import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.exception.ProductException;

@Service
public class AllProductServiceImpl implements IAllProductService {
    
	@Autowired 
	private IAllProductDao allProductDao;

	@Override
	public void create(AllProducts product) throws ProductException {
		// TODO Auto-generated method stub
		try {
		allProductDao.create(product);
		}
		catch(Exception e)
		{
			throw new ProductException("Product not saved successfully");
		}
	}

	@Override
	public List retrive() throws ProductException {
		// TODO Auto-generated method stub
		List<AllProducts> productList=allProductDao.retrive();
		if(productList.size()== 0)
		{
			throw new ProductException("Product List is Empty");
		}
		else
		{
			return productList;
		}
		
	
	}

	@Override
	public AllProducts findById(long id) throws ProductException {
		// TODO Auto-generated method stub
		AllProducts product=allProductDao.findById(id);
		if(product==null)
		{
			throw new ProductException("Product not found");
		}
		else
		{
			return product;
		}
	}
	
	

}

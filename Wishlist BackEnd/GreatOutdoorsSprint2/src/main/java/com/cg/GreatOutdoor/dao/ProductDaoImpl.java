package com.cg.GreatOutdoor.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.exception.ProductException;
@Repository
@Transactional
public class ProductDaoImpl implements IProductDao{
      @PersistenceContext
     private EntityManager entityManager;
      @Autowired
     private IUserDao userDao;
      @Autowired
    private  IAllProductDao allProduct;
      
	
      
      /**********************************
       *Method:        create(Product product)
       *description:   save the product in the database
       *parameter:     Take Product object in parameter
       *created by:    Raman Pandey
       *created date:  24-APR-2020
        **********************************/
      
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		entityManager.persist(product);
		
	}

	
	
	/**********************************
     *Method:        retrive(long userId)
     *description:   it display all product liked by particular user
     *Parameter:     it accept parameter as userId
     *@returns       List of product
     *created by     Raman Pandey
     *created date   24-APR-2020
     **********************************/
	@Override
	public List retrive(long userId) {
		// TODO Auto-generated method stub
		System.out.println("inside product dao");
		String getwishlistProductQuery="SELECT product.productId FROM Product  product where product.user.userId=:userId";
		TypedQuery<Long> wishlistQuery=entityManager.createQuery(getwishlistProductQuery,Long.class);
		wishlistQuery.setParameter("userId", userId);
		List<Long>productIdList=wishlistQuery.getResultList();
		System.out.println(productIdList);
		
		String getAllProductQuery="SELECT allproducts FROM AllProducts allproducts";
		TypedQuery<AllProducts> query=entityManager.createQuery(getAllProductQuery,AllProducts.class);
		List<AllProducts> allProducts=query.getResultList();
		List<AllProducts> list=allProducts.stream().filter(e->productIdList.stream().anyMatch(f->e.getProductId()==f)).collect(Collectors.toList());
		return list;
	}

	
   
	
	/**********************************
     *Method:          checkId(long userId, long productId)
     *description:     check the particular particular userId and productId exist or not if exist then check particular user already liked the product or not
     *parameter:       it takes productId as a parameter and userId
     *@returns         true if user not liked the product before otherwise false
     *created by       Raman Pandey
     *created date     24-APR-2020
**********************************/
	@Override
	public boolean checkId(long userId, long productId) throws ProductException
	{
		// TODO Auto-generated method stub
	
		
		System.out.println("IN PRODUCT DAO        UID= "+userId+" PID= "+productId);
		if(userDao.checkUserId(userId)==true && allProduct.checkProductId(productId)==true)
		{  System.out.println("product is available in ALLPRODUCTS =true");
		   String productQuery="SELECT product FROM Product product WHERE  product.user.userId=:userId  AND product.productId=:productId";
		   TypedQuery<Product> query=entityManager.createQuery(productQuery,Product.class);
		   query.setParameter("userId", userId);
		   query.setParameter("productId", productId);
		   
		   if(query.getResultList().size()==0)
		   {
			   return true;
		   }
		   else
		   {   throw new ProductException("Product ID already Exist in Wishlist");
			  // return false; 
		   }
		      
			
		}
		else if(userDao.checkUserId(userId)==true && allProduct.checkProductId(productId)==false)
		{ System.out.println("Product id does not found");
			return false;
		}
		else if(userDao.checkUserId(userId)==false && allProduct.checkProductId(productId)==true)
		{ System.out.println("User id does  not found");
			return false;
		}
		else
		{
			System.out.println("Both User ID and Product id not found");
			return false;
		}

	}
	

	
	
	
	/**********************************
     *Method:          deleteProduct(long userId , long productId)
     *description:     delete the particular product from user wishlist
     *parameter:       it takes userId,productId as a parameter
     *created by       Raman Pandey
     *created date     21-APR-2020
**********************************/
	@Override
	public void deleteProduct(long userId, long productId) {
		// TODO Auto-generated method stub
		String productQuery="SELECT product FROM Product product WHERE  product.user.userId=:userId  AND product.productId=:productId";
		TypedQuery<Product> query=entityManager.createQuery(productQuery,Product.class);
		query.setParameter("userId", userId);
		query.setParameter("productId", productId);
		Product product= query.getSingleResult();
		
		System.out.println(product);
		entityManager.remove(product);
		
	}


   
}
	


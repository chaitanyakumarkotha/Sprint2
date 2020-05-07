package com.cg.GreatOutdoor.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;
@Repository
@Transactional
public class WishlistProductDaoImpl implements IWishlistProductDao{
      @PersistenceContext
     private EntityManager entityManager;
      @Autowired
     private IUserDao userDao;
      @Autowired
    private  IProductDao ProductDao;
      
	
      
      /**********************************
       *Method:        create(Product product)
       *description:   save the product in the database
       *parameter:     Take Product object in parameter
       *created by:    Raman Pandey
       *created date:  24-APR-2020
        **********************************/
      
	@Override
	public boolean create(WishlistProduct product) {

		entityManager.persist(product);
		if (entityManager.find(WishlistProduct.class, product.getProductUserId()) != null) {
			return true;
		} else
			return false;

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
	public List<Product> retrive(long userId) {

		String getwishlistProductQuery = "SELECT product.productId FROM WishlistProduct  product where product.user.userId=:userId";
		TypedQuery<Long> wishlistQuery = entityManager.createQuery(getwishlistProductQuery, Long.class);
		wishlistQuery.setParameter("userId", userId);
		List<Long> productIdList = wishlistQuery.getResultList();

		String getProductQuery = "SELECT products FROM Product products";
		TypedQuery<Product> query = entityManager.createQuery(getProductQuery, Product.class);
		List<Product> allProducts = query.getResultList();
		List<Product> list = allProducts.stream()
				.filter(e -> productIdList.stream().anyMatch(f -> e.getProductId() == f)).collect(Collectors.toList());
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
	public boolean checkId(long userId, long productId) throws ProductException {
		if (userDao.checkUserId(userId) == true && ProductDao.checkProductId(productId) == true) {
			System.out.println("2");
			String str = "SELECT product.user.userId FROM WishlistProduct product";
			TypedQuery<Long> query = entityManager.createQuery(str, Long.class);
			List<Long> userIdList = query.getResultList();
			if (userIdList.contains(userId)) {
				System.out.println("3");
				String str2 = "SELECT product.productId FROM WishlistProduct product WHERE product.user.userId=:userId";
				TypedQuery<Long> query2 = entityManager.createQuery(str2, Long.class);
				query2.setParameter("userId", userId);
				List<Long> productList = query2.getResultList();
				if (productList.contains(productId)) {
					return true;
				}
			}
				}
		return false;

	}
	

	
	
	
	/**********************************
     *Method:          deleteProduct(long userId , long productId)
     *description:     delete the particular product from user wishlist
     *parameter:       it takes userId,productId as a parameter
     *created by       Raman Pandey
     *created date     21-APR-2020
**********************************/
	@Override
	public boolean deleteProduct(long userId, long productId) {
		System.out.println("1");
		if (userDao.checkUserId(userId) == true && ProductDao.checkProductId(productId) == true) {
			System.out.println("2");
			String str = "SELECT product.user.userId FROM WishlistProduct product";
			TypedQuery<Long> query = entityManager.createQuery(str, Long.class);
			List<Long> userIdList = query.getResultList();
			if (userIdList.contains(userId)) {
				System.out.println("3");
				String str2 = "SELECT product.productId FROM WishlistProduct product WHERE product.user.userId=:userId";
				TypedQuery<Long> query2 = entityManager.createQuery(str2, Long.class);
				query2.setParameter("userId", userId);
				List<Long> productList = query2.getResultList();
				if (productList.contains(productId)) {
					System.out.println("4");
					String productQuery = "SELECT product FROM WishlistProduct product WHERE  product.user.userId=:userId  AND product.productId=:productId";
					TypedQuery<WishlistProduct> query3 = entityManager.createQuery(productQuery, WishlistProduct.class);
					query3.setParameter("userId", userId);
					query3.setParameter("productId", productId);
					WishlistProduct product = query3.getSingleResult();
					entityManager.remove(product);
					return true;
				}

			}

		}
		System.out.println("5");
		return false;

	}
}
	


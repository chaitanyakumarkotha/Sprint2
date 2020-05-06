package com.cg.GreatOutdoor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {
	@PersistenceContext
	private EntityManager entityManager;

	/**********************************
	 * Method: create(AllProduct product) description: save the product in the
	 * database parameter: Take AllProduct object in parameter created by: Raman
	 * Pandey created date: 21-APR-2020
	 **********************************/

	@Override
	public void create(Product product) {
		
		entityManager.persist(product);
	}

	/**********************************
	 * Method: retrive() description: it display all product
	 * @returns List of product 
	 * created by Raman Pandey 
	 * created date 21-APR-2020
	 **********************************/
	@Override
	public List<Product> retrive() {		
		String getProductQuery = "SELECT products FROM Product products";
		TypedQuery<Product> query = entityManager.createQuery(getProductQuery, Product.class);

		return query.getResultList();

	}

	/**********************************
	 * Method: findById description: display the particular record by id 
	 * parameter: it accept productId as a parameter
	 * @returns: product detail 
	 * created by: Raman Pandey 
	 * created date: 21-APR-2020
	 **********************************/
	@Override
	public Product findById(long productId) {
		
		return entityManager.find(Product.class, productId);
	}

	/**********************************
	 * Method: checkProductId description: check the particular productId available or not
	 * parameter: it takes productId as a parameter
	 * @returns true if availale otherwise false 
	 * created by :Raman Pandey
	 * created date: 21-APR-2020
	 **********************************/

	@Override
	public boolean checkProductId(long productId) {
		
		if (entityManager.find(Product.class, productId) != null) {
			return true;
		} else {
			return false;
		}
	}

}

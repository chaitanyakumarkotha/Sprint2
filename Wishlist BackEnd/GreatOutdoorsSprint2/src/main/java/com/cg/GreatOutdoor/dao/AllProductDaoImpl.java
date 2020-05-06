package com.cg.GreatOutdoor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.AllProducts;
import com.cg.GreatOutdoor.entity.Product;
@Repository
@Transactional
public class AllProductDaoImpl implements IAllProductDao {
    @PersistenceContext
   private EntityManager entityManager;
    

    /**********************************
     *Method:        create(AllProduct product)
     *description:   save the product in the database
     *parameter:     Take AllProduct object in parameter
     *created by:    Raman Pandey
     *created date:  21-APR-2020
      **********************************/
    
    @Override
	public void create(AllProducts product) {
		// TODO Auto-generated method stub
       entityManager.persist(product);
       System.out.println("Product inserted in ALLPRODUCT Table");
	}
	
	
    
    /**********************************
     *Method:        retrive()
     *description:   it display all product
     *@returns       List of product
     *created by     Raman Pandey
     *created date   21-APR-2020
     **********************************/
     @Override
	public List retrive() {
		// TODO Auto-generated method stub
		String getAllProductQuery="SELECT allproducts FROM AllProducts allproducts";
		TypedQuery<AllProducts> query=entityManager.createQuery(getAllProductQuery,AllProducts.class);
		
		return query.getResultList();
		
	}

     
     /**********************************
      *Method:        findById
      *description:   display the paticular record by id
      *productId:     fetches the details of that particular id
      *@returns:      product detail
      *created by:    Raman Pandey
      *created date:  21-APR-2020
 **********************************/
	@Override
	public AllProducts findById(long productId) {
		// TODO Auto-generated method stub
		return entityManager.find(AllProducts.class, productId);
	}

	
	
	/**********************************
     *Method:          checkProductId
     *description:     check the particular productId available or not
     *parameter:       it takes productId as a parameter
     *@returns         true if availale otherwise false
     *created by       Raman Pandey
     *created date     21-APR-2020
**********************************/
	
	@Override
	public boolean checkProductId(long productId) {
		// TODO Auto-generated method stub
		System.out.println("IN ALL PRODUCT DAO    PID= "+productId);
		if(entityManager.find(AllProducts.class, productId)!=null)
		{
			System.out.println("true");
			return true;
		}
		else
		{
		return false;
		}
	}

}

package com.cg.GreatOutdoor.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.entity.User;
@Repository
@Transactional
public class AddressDaoImpl implements IAddressDao{
	@PersistenceContext
   private  EntityManager entityManager;

	
	/**********************************
     *Method:        create(Address address, long userId)
     *description:   save the adddress of particular User in the database
     *parameter:     Take address and userId as a parameter
     *created by:    Raman Pandey
     *created date:  27-APR-2020
      **********************************/
	@Override
	public boolean create(Address address,long userId) {
		
		User user=entityManager.find(User.class,userId);
		if(user != null)
		{
			user.addAddress(address);
			return true;
		}
		else
			return false;
	}

	

}

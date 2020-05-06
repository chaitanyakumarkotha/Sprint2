package com.cg.GreatOutdoor.dao;

import java.util.List;

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
     *description:   save the adddress of particular in the database
     *parameter:     Take address and userId as a parameter
     *created by:    Raman Pandey
     *created date:  27-APR-2020
      **********************************/
	@Override
	public void create(Address address,long userId) {
		// TODO Auto-generated method stub
		//create address
		User user=entityManager.find(User.class,userId);
		user.addAddress(address);
	}

	@Override
	public List retrive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

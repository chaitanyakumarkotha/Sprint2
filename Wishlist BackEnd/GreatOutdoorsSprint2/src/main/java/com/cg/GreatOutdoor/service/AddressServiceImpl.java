package com.cg.GreatOutdoor.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.GreatOutdoor.dao.IAddressDao;
import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.exception.AddressException;
@Service
public class AddressServiceImpl implements IAddressService {
 
	@Autowired
	private IAddressDao addressDao;
	
	@Override
	public void create(Address address,long userId) throws AddressException {
		// TODO Auto-generated method stub
		try {
		addressDao.create(address,userId);
		}
		catch(Exception exception)
		{
			throw new AddressException("Unable to create address");
		}

	}

	

}

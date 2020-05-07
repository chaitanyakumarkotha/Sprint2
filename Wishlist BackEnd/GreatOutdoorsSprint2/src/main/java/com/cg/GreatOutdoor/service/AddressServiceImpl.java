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
	public boolean create(Address address,long userId) throws AddressException {

		boolean status=addressDao.create(address,userId);
		if(status)
			return true;
		else
			throw new AddressException("Unable to create address");
		

	}

	

}

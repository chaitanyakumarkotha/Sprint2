package com.cg.GreatOutdoor.service;

import java.util.List;

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

	@Override
	public List retrive() throws AddressException {
		// TODO Auto-generated method stub
		List<Address> addressList= addressDao.retrive();
		if(addressList.size()== 0)
		{
			throw new AddressException("Address List is empty");
		}
		else
		{
			return addressList;
		}
		 
	}

	@Override
	public Address findById(long id) throws AddressException {
		// TODO Auto-generated method stub
		Address address=addressDao.findById(id);
		if(address==null)
		{
			throw new AddressException("Address not Found");
		}
		else {
		return address;
		}
	}

}

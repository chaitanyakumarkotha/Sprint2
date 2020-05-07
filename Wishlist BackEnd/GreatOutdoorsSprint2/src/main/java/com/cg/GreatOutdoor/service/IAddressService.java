package com.cg.GreatOutdoor.service;



import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.exception.AddressException;

public interface IAddressService {
	public boolean create(Address address, long userId) throws AddressException;
	
}

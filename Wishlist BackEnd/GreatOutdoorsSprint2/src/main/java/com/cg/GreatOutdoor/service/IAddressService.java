package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.Address;
import com.cg.GreatOutdoor.exception.AddressException;

public interface IAddressService {
	public void create(Address address, long userId) throws AddressException;
	public List retrive() throws AddressException;
	public Address findById(long id) throws AddressException;
}

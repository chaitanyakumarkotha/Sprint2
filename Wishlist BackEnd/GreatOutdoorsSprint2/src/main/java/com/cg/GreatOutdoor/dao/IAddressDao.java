package com.cg.GreatOutdoor.dao;

import java.util.List;

import com.cg.GreatOutdoor.entity.Address;

public interface IAddressDao  {
	public void create(Address address,long userId);
	public List retrive();
	public Address findById(long id);

}

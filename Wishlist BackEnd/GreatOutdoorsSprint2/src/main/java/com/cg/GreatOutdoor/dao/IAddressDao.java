package com.cg.GreatOutdoor.dao;

import com.cg.GreatOutdoor.entity.Address;

public interface IAddressDao  {
	public boolean create(Address address,long userId);

}

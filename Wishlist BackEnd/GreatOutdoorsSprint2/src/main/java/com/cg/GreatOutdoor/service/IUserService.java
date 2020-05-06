package com.cg.GreatOutdoor.service;

import java.util.List;

import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.exception.UserException;

public interface IUserService {
	public void create(User user) throws UserException;
	public List retrive() throws UserException;
	public User findById(long id) throws UserException;
	
}

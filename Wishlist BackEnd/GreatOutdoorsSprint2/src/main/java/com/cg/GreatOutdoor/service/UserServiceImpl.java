package com.cg.GreatOutdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.GreatOutdoor.dao.IUserDao;
import com.cg.GreatOutdoor.entity.User;
import com.cg.GreatOutdoor.exception.UserException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public boolean create(User user) throws UserException {
         boolean status=userDao.create(user);
         if(status)
         {
        	 return true;
         }
         else
         {	 
		   throw new UserException("Unable to create user");
		  }

	}

	@Override
	public List<User> retrive() throws UserException {

		List<User> userList = userDao.reterive();
		if (userList.isEmpty()) {
			throw new UserException("User List is Empty");
		} else {
			return userList;
		}
	}

	@Override
	public User findById(long id) throws UserException {

		User user = userDao.findById(id);
		if (user == null) {
			throw new UserException("User not Found");
		} else {
			return user;
		}
	}

}

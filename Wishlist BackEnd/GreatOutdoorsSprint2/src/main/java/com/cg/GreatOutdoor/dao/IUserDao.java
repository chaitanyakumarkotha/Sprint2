package com.cg.GreatOutdoor.dao;

import java.util.List;

import com.cg.GreatOutdoor.entity.User;

public interface IUserDao {
	public void create(User user);

	public List<User> reterive();

	public User findById(long id);

	public boolean checkUserId(long userId);
}

package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {
	
	public User login(User user);

	public List<User> getAllUser();


}

package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {
	
	public User login(User user);

	public List<User> getAllUser(Integer pageCount, Integer fenYeShu);

	public Integer getPages(int i);


}

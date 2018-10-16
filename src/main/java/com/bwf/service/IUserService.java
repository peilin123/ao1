package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {
	
	public User login(User user);

	public List<User> getAllUser(Integer pageCount, Integer fenYeShu);

	public Integer getPages(int i);

	public List<User> getAllUsers();

	public void saveUser(User user);

	public void editUser(User user);

	public User getUserByUserId(Integer userId);

	public void updateUser(User user);


}

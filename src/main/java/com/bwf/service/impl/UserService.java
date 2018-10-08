package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUser(user);
	}

}

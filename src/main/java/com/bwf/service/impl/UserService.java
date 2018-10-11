package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	UserMapper userMapper;

	@Transactional
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//获取带有简单的User
		User Okuser=userMapper.getUserByUser(user);
		//获取带有Menu的User
		if(Okuser!=null){
			Okuser=userMapper.getUserWithMenuAndOperateByUserId(Okuser.getUserId());
		}
		return Okuser ;
	}

	

}

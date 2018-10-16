package com.bwf.service.impl;

import java.util.List;

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

	@Override
	public List<User> getAllUser(Integer pageCount, Integer fenYeShu) {
		// TODO Auto-generated method stub
		Integer pageCounts=(pageCount-1)*fenYeShu;
		return userMapper.getAllUser( pageCounts,  fenYeShu);
	}

	@Override
	public Integer getPages(int per) {
		// TODO Auto-generated method stub
		 Integer pageCount=userMapper.getPages();
		 Integer pages=(int) Math.ceil( pageCount*1.0/per);
		return pages;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.getAllUsers();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.saveUser(user);
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	

}

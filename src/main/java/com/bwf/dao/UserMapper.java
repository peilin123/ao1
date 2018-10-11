package com.bwf.dao;


import org.springframework.stereotype.Repository;

import com.bwf.entity.User;

@Repository
public interface UserMapper {
	
	User getUserById(int id);	
	
	void add ( User user );
	
	void delete ( int id );
	
	void update ( User user );
	
	User getUserByUser(User user);
	
	User getUserWithMenuAndOperateByUserId(Integer userId);
}

package com.bwf.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	List<User> getAllUser(@Param("p") Integer pageCount,@Param("f") Integer fenYeShu);

	Integer getPages();

	List<User> getAllUsers();

	void saveUser(User user);

	void updateUser(User user);

	User getUserWithLeader(User currentUser);
	
}

package com.bwf.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.User;
import com.bwf.service.IUserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mvc.xml")
public class UserServiceTest {
	@Autowired
	IUserService userService;
	
	@Test
	public void testgetUserWithMenu(){
	
		User u= userService.getUserWithMenu(1);
		System.out.println(u.toString());
	}
}

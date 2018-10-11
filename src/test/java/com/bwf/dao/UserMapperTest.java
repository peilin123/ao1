package com.bwf.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserMapperTest {
	
		@Autowired
		UserMapper userMapper;
		
		@Test
		public void testGetUserWithMenuAndOperateByUserId(){
		
			User u=userMapper.getUserWithMenuAndOperateByUserId(1);
			System.out.println(u.getOperates().size()+"");
		}

}

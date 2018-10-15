package com.bwf.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserMapperTest {
	
		@Autowired
		UserMapper userMapper;
		
		Logger logger = org.slf4j.LoggerFactory.getLogger(UserMapperTest.class);
		
		@Test
		public void testGetUserWithMenuAndOperateByUserId(){
		
			User u=userMapper.getUserWithMenuAndOperateByUserId(1);
			logger.info(u.getOperates().size()+"");
		}
		
		@Test
		public void testGetAllUser(){
			//List<User> alluser=userMapper.getAllUser();
			//Assert.assertEquals(25, alluser.size());
			//logger.info( alluser.size()+"个");
		}

}

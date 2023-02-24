package com.itwill.user.dao.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.jdbc.User;
import com.itwill.user.dao.jdbc.UserDao;

@SpringBootApplication
@SpringBootTest
class UserDaoImplTest {
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	UserDao userDao;
	
	@Test
	void contextLoad() {
		System.out.println(applicationContext);
	}
	
	
	@Disabled
	@Test
	void testCreate()  throws Exception{
		User user=new User("test88", "test88", "테스트88", "test88@test88.com");
		assertEquals(userDao.create(user),1);
	}
	
	
	
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}
	//@Disabled
	@Test
	void testFindUser() throws Exception{
		User user=userDao.findUser("test88");
		assertNotNull(user);
		assertNotNull(user.getUserId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		System.out.println(user);
		
	}
	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}

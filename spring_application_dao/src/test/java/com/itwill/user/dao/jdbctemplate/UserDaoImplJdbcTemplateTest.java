package com.itwill.user.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
@SpringBootTest
class UserDaoImplJdbcTemplateTest {
	@Autowired
	UserDao userDao;
	@Disabled
	@Test
	
	void testCreate()  {
		User user = new User("난장판", "3333", "김난장", "난장@네이버");
		try {
		int rowCount =userDao.create(user);
		assertEquals(rowCount, 1);
		} catch (Exception e) {
			fail(e.getMessage());
			assertInstanceOf(DuplicateKeyException.class,e);
		}
	}
	@Disabled
	@Test
	void testUpdate() {
		User user = new User("멍군", "58584","수정함", "수정합니다");
		try {
			int updateCount = userDao.update(user);
			assertEquals(updateCount, 1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testRemove() {
		User user = new User("멍군", null, null, null);
		try {
			int removeCount = userDao.remove(user.getUserId());
			assertEquals(removeCount, 1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	void testFindUser() {
		User user = new User("난장판", null, null, null);
		try {
			User findUser = userDao.findUser(user.getUserId());
			assertEquals(findUser.getUserId(), "난장판");
			System.out.println(findUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testFindUserList() {
		try {
		List<User> userList = userDao.findUserList();
		System.out.println(userList);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}

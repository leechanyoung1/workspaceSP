package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
class GuestDaoImplJdbcTemplateTest {
	@Autowired
	GuestDao guestDao;
	@Disabled
	@Test
	void testSelectAll() throws Exception{
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());
		
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		System.out.println(guestDao.selectByNo(36));
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0, "김수수", null, "ㅇㄴㅁㅇ", "ㄷㅂㅈㄷ", "ㅇㄴㄹㄴㅁㄹ", "ㄷㅈㄷㅈㄷㅈ");
		System.out.println(guestDao.insertGuest(guest));
	}
	@Disabled
	@Test
	void testUpdateGuest() throws Exception {
		Guest guest = new Guest(29, "김수수", null, "ㅇㄴㅁㅇ", "ㄷㅂㅈㄷ", "ㅇㄴㄹㄴㅁㄹ", "ㄷㅈㄷㅈㄷㅈ");
		System.out.println(guestDao.updateGuest(guest));
	}
	
	@Test
	void testDeleteGuest() throws Exception {
		System.out.println(guestDao.deleteGuest(7));
	}

}

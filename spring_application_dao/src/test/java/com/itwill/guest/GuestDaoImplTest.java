package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.guest.dao.jdbc.Guest;
import com.itwill.guest.dao.jdbc.GuestDao;
//@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {

	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		guestDao.selectAll();
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(),0 );
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
		
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		assertNotNull(guestDao.selectByNo(6333));
		assertNotNull(guestDao.selectByNo(7));
		assertEquals(guestDao.selectByNo(7).getGuest_name(),"이상해씨");
		System.out.println(guestDao.selectByNo(7));
	}
	@Disabled
	@Test
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0, "김짱구", null, "asd@naver.com", "www.naver.com", "오호", "재미있는거");
		assertEquals(guestDao.insertGuest(guest), 1);
	}
	
	@Test
	void testUpdateGuest() throws Exception {
		Guest guest = new Guest(22, "김짱구수정", null, "수정asd@naver.com", "수정www.naver.com", "오수정호", "재미수정있는거");
		int updateRowcount = guestDao.updateGuest(guest);
		if(updateRowcount!=1) {
			fail("update 실패");
		}
	}
	
	
	
}

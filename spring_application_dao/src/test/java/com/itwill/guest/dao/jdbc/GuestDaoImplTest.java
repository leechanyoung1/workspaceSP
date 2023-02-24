package com.itwill.guest.dao.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.guest.dao.jdbc.Guest;
import com.itwill.guest.dao.jdbc.GuestDao;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {

	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
		
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		assertNull(guestDao.selectByNo(1231121212));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(),"요셉짱" );
		System.out.println(guestDao.selectByNo(196));
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception{
		Guest insertGuest=
				new Guest(0, "dkdkdkdkdkdkdkdkdkdkdkdkdkdkd", null,"test@gmail.com", "test.com", "타이틀", "컨텐트");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
		System.out.println("11111111111111111111111111111"+insertGuest);
	}
	@Disabled
	@Test
	void testUpdateGuest() throws Exception{
		Guest updateGuest=
				new Guest(263, "테스트수정", null,"testchange@gmail.com",
						"testchange.com", "타이틀수정", "컨텐트수정");
		int updateRowCount=guestDao.updateGuest(updateGuest);
		if(updateRowCount!=1) {
			fail("update 실패");
		}
	}
	
	
	
	

}

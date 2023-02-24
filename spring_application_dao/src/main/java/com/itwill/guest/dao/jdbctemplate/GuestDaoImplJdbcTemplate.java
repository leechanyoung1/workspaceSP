package com.itwill.guest.dao.jdbctemplate;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImplJdbcTemplate implements GuestDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Guest> selectAll() throws Exception {
		
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO,new Object[]{no},new int[]{Types.INTEGER},new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT,guest.getGuestName(),guest.getGuestEmail(),guest.getGuestHomepage(),guest.getGuestTitle(),guest.getGuestContent());
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,guest.getGuestName(),guest.getGuestEmail(),guest.getGuestHomepage(),guest.getGuestTitle(),guest.getGuestContent(),guest.getGuestNo());
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,no);
	}
	
	
	
	
}
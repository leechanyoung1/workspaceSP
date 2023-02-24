package com.itwill.guest.dao.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A.JdbcTemplate"+jdbcTemplate);
		System.out.println("B.JdbcTemplate DataSource"+jdbcTemplate.getDataSource());
		//System.out.println("C.JdbcTemplate DataSource Connection"+jdbcTemplate.getDataSource().getConnection());
		
		System.out.println("1.JdbcTemplate객체얻기");
		/*
		 * select--> queryForObject 반환타입[String,Wrapper,DTO]
		 */
		/*
		 * queryForObject 반환타입[Guest]
		 */
		String selectDtoSql ="select * from guest where guest_no = ?";
		Object[] paramArray1 = {263};
		Object[] paramArray2 = new Object[]{263};
		/*
		 * <BeanPropertyRowMapper 클래스>
		 * ResultSet객체로부터 테이타를 컬럼이름으로 get해서
		 * Guest객체 생성후 테이블컬럼이름과 동일한이름의 Guest객체의 property(멤버변수)에 대입해주는 클래스
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class); //Result Set을 해줌
		
		/*
		 * RowMapper<Guest> guestMapper = new RowMapper<Guest>() {
		 * 
		 * @Override public Guest mapRow(ResultSet rs,int rowNum) throws SQLException {
		 * Guest guest = new Guest(rs.getInt(guest_no), "", "", "", "", "", "");
		 * 
		 * return guest; } };
		 */
		
		
		
		Guest guest= jdbcTemplate.queryForObject(selectDtoSql,new Object[]{37},new int[]{Types.INTEGER},guestBeanPropertyRowMapper ) ;
		System.out.println("queryForObject[Guest]"+guest);
		
		/*
		 * queryForObject 반환타입[String Wrapper]
		 */
		String selectStringSql = "select guest_name from guest where guest_no =?";
		String guest_name =jdbcTemplate.queryForObject(selectStringSql,new Object[]{37},new int[]{Types.INTEGER} ,String.class);
		System.out.println("queryForObject[String]"+guest_name);
		
		/************************************************
		  select--> query반환타입[List<Dto>]
		************************************************/
		/*
		 * query[반환타입 List<Guest>]
		 */
		String selectDtoListSql ="select * from guest";
		List<Guest> guestList =jdbcTemplate.query(selectDtoListSql,guestBeanPropertyRowMapper);
		System.out.println("query[List<Guest>]"+guestList);
		
		/************************************************
		  select--> queryForList반환타입[List<String,Wrapper>]
		************************************************/
		String selectStringListSql = "select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("queryFOrList[List<String>]"+guest_nameList);
		
		/************************************************
		  select--> queryForMap반환타입[Map<String,Object>]
		************************************************/
		String selectMapSql = "select * from guest where guest_no=?";
		Map rowMap  = jdbcTemplate.queryForMap(selectMapSql,new Object[]{37},new int[]{Types.INTEGER});
		System.out.println("-->queryForMap반환타입[Map<String,Object>]"+rowMap);
		
		
		String selectMapListSql = "select * from guest ";
		List rowMapList  = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("-->queryForList반환타입[List<map<String,Object>>]"+rowMapList);
		
		
		
		
		/*
		 * DML(update,delete,insert)--> update 반환타입[roeCOunt(int)]
		 */
		String insertSql = "insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql,"김팔미","고로케","단팥빵","슈크림빵","맘모스빵");
		System.out.println("insert rowCount "+rowCount);
		String updateSql = "update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no= ?";
		rowCount = jdbcTemplate.update(updateSql,"껄껄껄","껄.com","www.cksdud","고추장","먹기",37);
		System.out.println("update rowCount "+rowCount);
		String deleteSql = "delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql,37);
		System.out.println("delete rowCount "+rowCount);
		
		
		
	}

}

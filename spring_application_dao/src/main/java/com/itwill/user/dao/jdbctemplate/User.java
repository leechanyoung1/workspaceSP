package com.itwill.user.dao.jdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
/*
 * @Data: 클래스 내에 멤버 변수를 private으로 선언하고, 해당 변수들에 대한 Getter/Setter 메소드와, toString(), equals(), hashCode() 메소드를 자동으로 생성해줍니다.

@NoArgsConstructor: 인자가 없는 기본 생성자를 생성합니다.

@AllArgsConstructor: 모든 인스턴스 변수를 받는 생성자를 생성합니다.

@ToString: 객체의 toString() 메소드를 자동으로 생성합니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	
	private String userId;
	private String password;
	private String name;
	private String email;
	/*
	 * 패스워드 일치여부
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	

}








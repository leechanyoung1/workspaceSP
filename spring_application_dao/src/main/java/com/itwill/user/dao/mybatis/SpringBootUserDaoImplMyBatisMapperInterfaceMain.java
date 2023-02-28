package com.itwill.user.dao.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.user.dao.mybatis.mapper")
public class SpringBootUserDaoImplMyBatisMapperInterfaceMain {
	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootUserDaoImplMyBatisMapperInterfaceMain.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		UserDao userDao=
				(UserDao)applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
		
	}

}
package com.itwill.user.dao.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.user.dao.mybatis.mapper")
public class SpringBootUserDaoImplMyBatisMapperInterfaceMain {
	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container�ʱ�ȭ����[ApplicationContext��ü��������]");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootUserDaoImplMyBatisMapperInterfaceMain.class, args);
		System.out.println("----Spring Container�ʱ�ȭ��[ApplicationContext��ü������]");
		UserDao userDao=
				(UserDao)applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
		
	}

}
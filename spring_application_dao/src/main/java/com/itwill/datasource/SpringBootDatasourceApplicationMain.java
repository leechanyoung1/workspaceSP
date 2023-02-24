package com.itwill.datasource;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDatasourceApplicationMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootDatasourceApplicationMain.class, args);
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println("1.DataSource:"+dataSource);
		System.out.println("2.Connection:"+dataSource.getConnection());
		
	}

}

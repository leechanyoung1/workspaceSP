package com.mybatis3.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoJOINSELECTMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------findStudentByIdWithAddress------------------");
		Student student= studentDao.findStudentByIdWithAddress(1);
		System.out.println(student);
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println("---------findStudentByIdWithAddressWithCourses-------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		
		
		
		
	}
}
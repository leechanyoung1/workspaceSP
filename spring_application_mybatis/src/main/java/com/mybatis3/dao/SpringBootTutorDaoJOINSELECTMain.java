package com.mybatis3.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.dao.mapper.TutorDao;
import com.mybatis3.domain.Student;
import com.mybatis3.domain.Tutor;

@SpringBootApplication
public class SpringBootTutorDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootTutorDaoJOINSELECTMain.class, args);
		TutorDao tutorDao=(TutorDao)appicationContext.getBean(TutorDao.class);
		
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(tutorDao.findTutorByWithCourses(1));
		System.out.println("---------findStudentByIdWithAddressWithCourses-------");
		System.out.println(tutorDao.findTutorByWithCourses(1));
		
		
		
		
	}
}
package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(10000, "아오", "네이버@구글", new Date());
		System.out.println("####row count:"+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0, "다오", "나이버@구글", new Date());
		System.out.println("####row count:"+studentDao.insertStudentBySequence1(student2));
		System.out.println("---------insertStudentBySequence2--------------------");
		
		
		Student student3 = new Student(0, "아오", "다이버@구글", new Date());
		System.out.println("####row count:"+studentDao.insertStudentBySequence2(student3));
		System.out.println("####pk:"+student3.getStudId());
		System.out.println("####:"+studentDao.findStudentById(student3.getStudId()));
		System.out.println("---------updateStudentById---------------------------");
		Student updateStudent = studentDao.findStudentById(6);
		updateStudent.setName("변경");
		updateStudent.setEmail("골뱅이네이버");
		updateStudent.setDob(new SimpleDateFormat("yyyy/MM/DD").parse("2000/02/02"));
		System.out.println("update row count:"+studentDao.updateStudentById(updateStudent));
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println(studentDao.deleteStudentById(10000));
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("---------deleteStudentByNameLike---------------------");
	}
}
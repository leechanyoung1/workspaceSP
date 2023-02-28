package com.mybatis3.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Tutor;
@Mapper
public interface TutorMapper {
	/*
	 * <select id="findTutorByIdWithCourses" 
			parameterType="java.lang.Integer"
			resultMap="tutorWithCoursesResultMap">
			select t.tutor_id,t.name as tutor_name,email,
			 		course_id,c.name as course_name,description,
			 		start_date,end_date
			from tutors t  
			join courses c 
			on t.tutor_id = c.tutor_id 
			where t.tutor_id=#{tutorId}
	</select>
	 */
	@Results(id ="findTutorByIdWithCourses",value = {
			@Result(column = "tutor_id",property = "tutorId"),
			@Result(column = "tutor_name",property = "name"),
			@Result(column = "email",property = "email"),
			@Result(column = "course_id",property = "courses",javaType = List.class ,many=@Many(select = "com.mybatis3.dao.mapper.CourseMapper.findCourseById"))
	} )
	@Select("select t.tutor_id,t.name as tutor_name,email,"
			+ "			 		course_id,c.name as course_name,description,"
			+ "			 		start_date,end_date"
			+ "			from tutors t  "
			+ "			join courses c "
			+ "			on t.tutor_id = c.tutor_id "
			+ "			where t.tutor_id=#{tutorId}")
	public Tutor findTutorByIdWithCourses(Integer tutorId);
}
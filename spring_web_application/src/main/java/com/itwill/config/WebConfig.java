package com.itwill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebConfig implements WebMvcConfigurer{
	/*
	 * 위 코드는 스프링 MVC에서 뷰 컨트롤러를 추가하는 메소드입니다.
	 *  "/" 경로로 요청이 들어오면 "forward:/index.jsp" 뷰를 반환하도록 설정하고 있습니다. 
	 *  즉, 홈페이지로 접속할 때 index.jsp를 보여주도록 설정하는 코드입니다.
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
}	

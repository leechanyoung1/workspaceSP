package com.itwill.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/*
 * 위 코드는 스프링 MVC에서 뷰 컨트롤러를 추가하는 메소드입니다.
 *  "/" 경로로 요청이 들어오면 "forward:/index.jsp" 뷰를 반환하도록 설정하고 있습니다. 
 *  즉, 홈페이지로 접속할 때 index.jsp를 보여주도록 설정하는 코드입니다.
 */


@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		 //registry.jsp("/WEB-INF/views",".jsp");
	}
	
	/****************************spring mvc 객체등록*****************************/
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0);
		return beanNameViewResolver;
	}
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		return internalResourceViewResolver;
		
	}
	
	
	
	/*
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties urlProperties = new Properties();
		urlProperties.put("/hello", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	@Bean("helloController")
	public HelloController helloController() {
		return new HelloController();
	}
	*/
	
}
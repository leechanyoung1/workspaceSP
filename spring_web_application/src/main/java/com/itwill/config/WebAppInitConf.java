package com.itwill.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * web.xml 설정을 대신할 클래스
 * -톰캣 실행시 기본설정
 * 
 */
/*
 * 위 코드는 서블릿 컨테이너가 시작될 때 실행되는 메소드입니다. 
 * AnnotationConfigWebApplicationContext를 사용하여 
 * WebConfig 클래스를 등록하고, DispatcherServlet을 생성하여 
 * "dispatcher"라는 이름으로 서블릿 컨텍스트에 등록합니다. 
 * 이후, dynamic.setLoadOnStartup(0)을 호출하여 
 * 서블릿이 컨테이너에서 시작될 때 로드되도록 설정하고,
 *  dynamic.addMapping("/")을 호출하여 "/" 경로로 들어오는 
 *  모든 요청을 DispatcherServlet으로 보내도록 설정합니다.
 */
public class WebAppInitConf  implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		ServletRegistration.Dynamic dynamic =servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dynamic.setLoadOnStartup(0);
		dynamic.addMapping("/");
		
	}

}

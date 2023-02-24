package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductService;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring Container객체생성
		 * -ApplicationContext[BeanFactory]객체생성
		 */
		
		/*
		 *1.Spring Bean설정파일을 읽어서 SpringContainer객체생성 
		 */
		System.out.println("-----------------ApplicationContext생성시작------------------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		System.out.println("-----------------ApplicationContext생성끝------------------------");
		/*
		 * Spring Container객체[ApplicationContext객체]로부터
		 * productService 아이디객체 참조얻기
		 */
		ProductService productService = (ProductService)applicationContext.getBean("productService");
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(111));
		System.out.println("-------singleton객체");
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
	
	}
}

package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = "com.itwill.product")
public class SpringbootAppliactionMain {

	public static void main(String[] args) {
		System.out.println("-----------------ApplicationContext생성시작------------------------");
		ApplicationContext applicationContext = SpringApplication.run(SpringbootAppliactionMain.class, args);
		System.out.println("-----------------ApplicationContext생성끝------------------------");
		ProductService productService = (ProductService)applicationContext.getBean("productService");//getBean을 호출함으로써 인스턴스가 생성되고 스프링 컨테이너의 Singleton으로 등록이 된다.
		
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(111));

	}

}

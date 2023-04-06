package com.itwill.jpa.relation.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Test
	void productSaveAndUpdate() {
		Product product=Product.builder()
						.name("JPA일주일만하면")
						.price(3000)
						.stock(1000)
						.build();
		productRepository.save(product);
		
		product.setName("JSP하루만하면");
		productRepository.save(product);
	}
	
	@Test
	void productProductDetailSaveRead() {
		
			Product product=new Product();
			product.setName("스프링시큐리디변경");
			product.setPrice(80000);
			product.setStock(500);
			productRepository.save(product);
			
			ProductDetail productDetail=new ProductDetail();
			productDetail.setDescription("아주좋은책이여요!!!");
			productDetail.setProduct(product);
			productDetailRepository.save(productDetail);
			
			System.out.println("-----------------read--------------------");
			System.out.println("Product:"+productRepository.findById(1L).get());
			System.out.println("Product --> ProductDetail:"+productRepository.findById(1L).get().getProductDetail());
			
		}
	}
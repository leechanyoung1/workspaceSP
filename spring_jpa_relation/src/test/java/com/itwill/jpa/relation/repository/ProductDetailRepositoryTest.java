package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductDetailRepository productdetailRepository;
	@Autowired
	ProductRepository productRepository;

	@Test
	void productDetailProductSaveRead() {
		Product product = new Product();
		product.setName("김덕배");
		product.setPrice(3000);
		product.setStock(500);
		productRepository.save(product);

		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription("아주좋은책이여요!!");
		productDetail.setProduct(product);
		productdetailRepository.save(productDetail);
		
		System.out.println("--------------------------------------------------");
		
		System.out.println(">>>ProductDetail" + productdetailRepository.findById(2L).get());
		
		System.out.println(">>>ProductDetail-->Product" + productdetailRepository.findById(2L).get().getProduct());
	}

}

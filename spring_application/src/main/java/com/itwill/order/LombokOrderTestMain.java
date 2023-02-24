package com.itwill.order;

import java.time.LocalDateTime;
import java.util.Date;

public class LombokOrderTestMain {

	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderNo(1);
		order.setOrderTitle("tv외");
		order.setOrderDate(new Date());
		System.out.println(order);
		Order order2 = new Order(2,"phone",new Date());
		System.out.println(order2);
		

	}

}

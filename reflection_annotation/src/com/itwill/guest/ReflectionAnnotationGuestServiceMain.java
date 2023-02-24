package com.itwill.guest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductServiceImpl;

public class ReflectionAnnotationGuestServiceMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 1.com.itwill.guest package에있는 모든클래스의  @Annotation을 읽어서 
		 *   Spring Container객체[ApplicationContext객체]생성
		 */
		System.out.println("############### Spring Container 초기화 start ############# ");
		HashMap applicationContext = new HashMap();

		
		
		Class guestPackageClass0 = DataSource.class;
		Class guestPackageClass1 = GuestDaoImpl.class;
		Class guestPackageClass2 = GuestServiceImpl.class;
		Class[] guestPackageClasses = new Class[3];
		guestPackageClasses[0] = guestPackageClass0;
		guestPackageClasses[1] = guestPackageClass1;
		guestPackageClasses[2] = guestPackageClass2;

		System.out.println("--------@Component 객체생성--------------");
		for (Class clazz : guestPackageClasses) {
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof Component) {
					System.out.println(clazz.getSimpleName() + ":" + annotation);
					Component myComponent = (Component) annotation;
					String componentName = myComponent.value();
					System.out.println("--componentName--"+componentName);
					Object newInstance = clazz.newInstance();
					System.out.println("--newInstance--"+newInstance);
					applicationContext.put(componentName, newInstance);
				}
			}
		}
		
		System.out.println("--------@AutoWire setter method호출--------------");
		Iterator<String> beanIdIterator= applicationContext.keySet().iterator();
		/*
		 * Iterator의 장점
			1. 컬렉션에서 요소를 제어하는 기능
			2. next() 및 previous()를 써서 앞뒤로 이동하는 기능
			3. hasNext()를 써서 더 많은 요소가 있는지 확인하는 기능
		 */
		System.out.println(beanIdIterator);
		while (beanIdIterator.hasNext()) {
			String beanId=beanIdIterator.next();
			System.out.println("--beanId---"+beanId);//guestService,dataSource,guestDao
			Object beanInstance=applicationContext.get(beanId);
			System.out.println("--beanInstance--"+beanInstance);
			Class beanClass=beanInstance.getClass();
			System.out.println("--beanClass---"+beanClass);//class com.itwill.guest.DataSource,class com.itwill.guest.GuestDaoImpl
			Method[] methods = beanInstance.getClass().getMethods();
			System.out.println("--methods--"+methods);
			for (Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof AutoWire) {
						AutoWire myAutoWire = (AutoWire) annotation;
						System.out.println(myAutoWire);
						System.out.println(beanClass.getSimpleName() + ":" + method);
						String componentId = myAutoWire.value();
						System.out.println("--componentId--"+componentId);
						Object injectionObject=applicationContext.get(componentId);
						System.out.println("--injectionObject--"+injectionObject);
						method.invoke(beanInstance, injectionObject);
						
						
					}
				}
			}
		}
		
		//System.out.println(applicationContext);
		System.out.println("############### Spring Container 초기화 end ############# ");

		System.out.println("가. Spring Container객체[ApplicationContext객체]로부터 guestService 란 빈이름의 객체참조얻기");
		 GuestService guestService = (GuestService) applicationContext.get("guestService");
		 System.out.println(guestService.selectAll());
	}

}

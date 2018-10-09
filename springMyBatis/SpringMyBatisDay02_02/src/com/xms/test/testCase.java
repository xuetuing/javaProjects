package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.ExampleBean;
import com.xms.entity.User;

public class testCase {
	
	//Bean的延迟实例化
	@Test
	public void testOne(){
		String xml = "spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xml);
		ac.getBean("exampleBean",ExampleBean.class);
		
		
	}
	//实例化Bean方式
	@Test
	public void testTwo(){
		//实例化容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		User user = ac.getBean("admin",User.class);
		System.out.println(user);
		
	}
	@Test
	public void testThree(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		User one = ac.getBean("admin",User.class);
		User two = ac.getBean("admin",User.class);
		System.out.println(one == two);
		
	}
	//Bean对象的生命周期
	@Test
	public void testFour(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring.xml");
		aac.getBean("exampleBean",ExampleBean.class);
		aac.close();
	}
	
}










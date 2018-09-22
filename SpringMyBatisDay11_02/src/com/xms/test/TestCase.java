package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.controller.TestController;

public class TestCase {

	@Test
	public void testOne(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		TestController testController = ac.getBean("testController",TestController.class);
		testController.findAll();
	}
	
	
}

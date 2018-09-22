package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.service.EmpService;

public class TestCase {

	@Test
	public void testOne(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		EmpService empService = ac.getBean("empService",EmpService.class);
		empService.addEmps();
	}
	
	
}

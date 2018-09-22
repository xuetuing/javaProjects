package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.Company;
import com.xms.entity.Dept;
import com.xms.entity.Emp;

public class testCase {
	
	//Spring 容器的实例化
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	@Test
	public void testOne(){
		//Setter注入
		Emp emp = ac.getBean("emp",Emp.class);
		System.out.println(emp);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
	
	}
	@Test
	public void testTwo(){
		//构造器注入
		Dept dept = ac.getBean("dept",Dept.class);
		System.out.println(dept);
		System.out.println(dept.getId());
		System.out.println(dept.getName());
		
	}
	@Test
	public void testThree(){
		Company company = ac.getBean("company",Company.class);
		
		System.out.println(company);
		System.out.println(company.getEmp());
		System.out.println(company.getEmp().getId());
		System.out.println("==========================");
		System.out.println(company.getDept());
		System.out.println(company.getDept().getName());
		
		
	}
	
}










package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.Computer;
import com.xms.entity.Manager;
import com.xms.entity.Programmer;
import com.xms.entity.Student;
import com.xms.entity.Teacher;

public class TestCaste {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	
	//@Autowired / @Qualifer方式以构造器方式注入
	@Test
	public void testOne(){
		Programmer pro = ac.getBean("programmer",Programmer.class);
		
		System.out.println(pro);
		System.out.println(pro.getComputer());
		System.out.println(pro.getComputer().getName());
		System.out.println(pro.getComputer().getPrice());
	}
	//@Autowired / @Qualifer方式以setter方式注入
	@Test
	public void testTwo(){
		Teacher teacher = ac.getBean("teacher",Teacher.class);
		
		System.out.println(teacher.getComputer());
		System.out.println(teacher.getComputer().getName());
		System.out.println(teacher.getComputer().getPrice());
		
	}
	//@Autowired/@Qualifer方式作用在属性上
	@Test
	public void testThree(){
		Student student = ac.getBean("student",Student.class);
		
		System.out.println(student);
		System.out.println(student.getComputer());
		System.out.println(student.getComputer().getName());
		System.out.println(student.getComputer().getPrice());
		
	}
	//@Resource方式以setter方式注入
	@Test
	public void testFour(){
		Manager manager = ac.getBean("manager",Manager.class);
		
		System.out.println(manager);
		System.out.println(manager.getComputer());
		System.out.println(manager.getComputer().getName());
		System.out.println(manager.getComputer().getPrice());
		
	}
	@Test
	public void testFive(){
		Computer computer = ac.getBean("com",Computer.class);
		
		System.out.println(computer);
		System.out.println(computer.getName());
		
		
	}
		
		
}

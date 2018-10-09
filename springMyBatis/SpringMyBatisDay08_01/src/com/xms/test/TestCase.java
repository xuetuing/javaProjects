package com.xms.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.EmpMapper;
import com.xms.entity.Emp;

public class TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper mapper = ac.getBean("empMapper",EmpMapper.class);
	
	@Test
	public void testOne(){
		List<Emp> emps = mapper.findAll();
		for(Emp emp : emps){
			System.out.println(emp.getEname());
		}
		
	}
	@Test
	public void testTwo(){
		Emp emp = mapper.findByEmpno(1004);
		System.out.println(emp.getEname());
	}
	@Test
	public void testThree(){
		Emp emp = new Emp();
		emp.setEname("赵云");
		emp.setSalary(45564.23);
		emp.setBonus(235.23);
		emp.setDeptno(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		
		mapper.save(emp);
	}
	@Test
	public void testFour(){
		Emp emp = mapper.findByEmpno(1005);
		emp.setSalary(55555.23);
		emp.setBonus(555.23);
		emp.setDeptno(20);
		
		mapper.update(emp);
	}
	@Test
	public void testFive(){
		mapper.delete(1005);
	}
	
	
	
}













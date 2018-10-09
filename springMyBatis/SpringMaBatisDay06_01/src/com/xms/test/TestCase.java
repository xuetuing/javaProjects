package com.xms.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;

public class TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	EmpDao dao = ac.getBean("empDao",EmpDao.class);
	
	@Test
	public void testOne(){
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp.getEname()+","+emp.getSalary());
		}
	}
	@Test
	public void testTwo(){
		Emp emp = dao.findByEmpno(1002);
		
		System.out.println(emp.getEname()+","+emp.getSalary());
		
	}
	@Test
	public void testThree(){
		Emp emp = new Emp();
		emp.setEmpno(null);
		emp.setEname("张无忌");
		emp.setSalary(55565.21);
		emp.setBonus(666.23);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(5);
		
		dao.save(emp);
	}
	@Test
	public void testFour(){
		Emp emp = dao.findByEmpno(1005);
		emp.setEname("张三丰");
		emp.setSalary(9999.99);
		
		dao.update(emp);
	}
	@Test
	public void testFive(){
		dao.delete(1005);
	}
	
}









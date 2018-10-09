package com.xms.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.EmpMapper;
import com.xms.entity.Condition;
import com.xms.entity.Emp;

public class TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper empMapper = ac.getBean("empMapper",EmpMapper.class);
	
	@Test
	public void testOne(){
		Condition condition = new Condition();
		condition.setDeptno(10);
		List<Emp> emps = empMapper.findByDeptno(condition);
		for(Emp emp : emps){
			System.out.println(emp.getEmpno()+":"+emp.getEname());
		}
		
	}
	@Test
	public void testTwo(){
		Condition condition = new Condition();
		condition.setSalary(null);
		List<Emp> emps = empMapper.findBySalary(condition);
		for(Emp emp : emps){
			System.out.println(emp.getEmpno()+":"+emp.getEname()+" "+emp.getSalary());
		}
		
	}
	@Test
	public void testThree(){
		Condition condition = new Condition();
		condition.setSalary(30000.00);
		condition.setDeptno(null);
		List<Emp> emps = empMapper.findByDeptnoAndSalary(condition);
		for(Emp emp : emps){
			System.out.println(emp.getEmpno()+":"+emp.getEname()+" "+emp.getSalary());
		}
		
	}
	@Test
	public void testFour(){
		Emp emp = new Emp();
		emp.setEname("孙悟空");
		emp.setDeptno(10);
		emp.setEmpno(1005);
		
		empMapper.update(emp);
	}
	@Test
	public void testFive(){
		List<Integer> empnos = new ArrayList<Integer>();
		empnos.add(1001);
		empnos.add(1003);
		empnos.add(1006);
		
		Condition condition = new Condition();
		condition.setEmpnos(empnos);
		
		List<Emp> list = empMapper.findByEmpno(condition);
		for(Emp emp : list){
			System.out.println(emp.getEmpno()+":"+emp.getEname());
		}
	}
	
}

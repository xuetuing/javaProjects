package com.xms.test;

import java.sql.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.DeptMapper;
import com.xms.dao.EmpMapper;
import com.xms.entity.Dept;
import com.xms.entity.Emp;

public class TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	DeptMapper deptMapper = ac.getBean("deptMapper",DeptMapper.class);
	EmpMapper empMapper = ac.getBean("empMapper",EmpMapper.class);
	
	@Test
	public void testOne(){
		Dept dept = new Dept();
		dept.setDname("行政部");
		dept.setAddress("广东");
		
		deptMapper.save(dept);
		
		Emp emp = new Emp();
		emp.setEname("赵云");
		emp.setSalary(8888.00);
		emp.setBonus(555.00);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(dept.getDeptno());
		
		empMapper.save(emp);
	}
	
	
}

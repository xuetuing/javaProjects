package com.xms.service;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.EmpMapper;
import com.xms.entity.Emp;

@Service
public class EmpService {

	@Resource
	private EmpMapper empMapper;
	
	public void addEmps() throws ClassNotFoundException{
		Emp one = new Emp();
		one.setEname("张三丰");
		one.setSalary(44440.44);
		one.setBonus(555.66);
		one.setHiredate(new Date(System.currentTimeMillis()));
		one.setDeptno(20);
		
		empMapper.save(one);
		//java.lang.NumberFormatException,运行异常
//		Integer.parseInt("ABC");
		
		//检查异常：ClassNotFoundException
		Class.forName("OpenClass");
		
		Emp two = new Emp();
		two.setEname("张林");
		two.setSalary(33340.44);
		two.setBonus(225.66);
		two.setHiredate(new Date(System.currentTimeMillis()));
		two.setDeptno(20);
		
		empMapper.save(two);
		
		
	}
}

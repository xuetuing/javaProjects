package com.xms.test;

import java.util.List;

import org.junit.Test;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;

public class TestCases {
	DeptDao dao = new DeptDao();
	
	@Test
	public void testOne(){
		
		List<Dept> list =  dao.findAll();
		for(Dept dept : list){
			System.out.println(dept.getDname()+":"+dept.getAddress());
		}
	}
	@Test
	public void testTwo(){
		Dept dept =  dao.findByDname("研发部");
		System.out.println(dept.getDname()+":"+dept.getAddress());
	}
	@Test
	public void testThree(){
		Dept dept = new Dept();
		dept.setDeptno(40);
		dept.setDname("行政部");
		dept.setAddress("杭州");
		
		dao.save(dept);
		
	}
	@Test
	public void testFour(){
		Dept dept = dao.findByDname("行政部");
		dept.setAddress("天津");
		
		dao.update(dept);
		
	}
	
	@Test
	public void testFive(){

		dao.delete(40);
	}
	
	
	
	
}

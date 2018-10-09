package com.xms.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.dao.DeptDao;
import com.xms.dao.DeptDao1;
import com.xms.entity.Dept;

public class TestCase1 {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	DeptDao dao = ac.getBean("deptDao",DeptDao.class);
	DeptDao1 dao1 = ac.getBean("deptDao1",DeptDao1.class);
	@Test
	public void testOne(){
		List<Dept> depts = dao.findAllDept();
		for(Dept dept : depts){
			System.out.println(dept.getDname()+","+dept.getAddress());
		}
		
	}
	//根据部门号查询
	@Test
	public void testTwo(){
		Dept dept = dao.findByDeptno(10);
		
		System.out.println(dept.getDname()+","+dept.getAddress());
	}
	//增加部门信息
	@Test
	public void testThree(){
		Dept dept = new Dept();
		dept.setDeptno(40);
		dept.setDname("运营部");
		dept.setAddress("广州");
		
		dao.save(dept);
	}
	//修改部门信息
	@Test
	public void testFour(){
		Dept dept = dao.findByDeptno(40);
		dept.setDname("策划部");
		dept.setAddress("徐州");
		
		dao.update(dept);
	}
	//删除部门信息
	@Test
	public void testFive(){
		
		dao.delete(40);
	}
	@Test
	public void testSix(){
		List<Dept> depts = dao1.findAll();
		for(Dept dept : depts){
			System.out.println(dept.getDname()+","+dept.getAddress());
		}
		
	}
	
	
}











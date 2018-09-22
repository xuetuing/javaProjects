package com.xms.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;

public class Testcase {
	EmpDao dao = new EmpDao();
	@Test
	public void testOne(){
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp.getEname()+","+emp.getSalary());
		}
	}
	@Test
	public void testTwo(){
		Emp emp = dao.findByEmpno(1007);
		System.out.println(emp.getEname()+","+emp.getSalary());
		
	}
	@Test
	public void testThree(){
		Emp emp = new Emp();
		emp.setEname("赵云");
		emp.setSalary(50000.00);
		emp.setBonus(366.33);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(5);
		
		dao.save(emp);
	}
	
	@Test
	public void testFour(){
		Emp emp = dao.findByEmpno(1006);
		emp.setEname("赵大勇");
		emp.setSalary(30050.23);
		emp.setBonus(400.33);
		
		dao.update(emp);
	}
	@Test
	public void testFive(){
		
		dao.delete(1006);
	}
	@Test
	public void testSix(){
		Map<String,Object> map = dao.findEmpAndDeptByEmpno(1001);
		System.out.println(map.size());
		
		System.out.println(map.get("empno"));
		System.out.println(map.get("ename"));
		System.out.println(map.get("salary"));
		System.out.println(map.get("bonus"));
		System.out.println(map.get("hiredate"));
		System.out.println(map.get("deptno"));
		System.out.println(map.get("dname"));
		System.out.println(map.get("address"));
		
	}
	@Test
	public void testSeven(){
		List<Map<String,Object>> list = dao.findEmpAndDept();
		System.out.println(list.size());
		for(Map<String,Object> map : list){
			System.out.println(map.get("empno")+" "+map.get("ename")+" "+map.get("salary")+" "+map.get("bonus")+" "+map.get("hiredate")
					+" "+map.get("deptno")+" "+map.get("dname")+" "+map.get("address"));
		}
		
		
	}
	
	
	
	
	
	
}

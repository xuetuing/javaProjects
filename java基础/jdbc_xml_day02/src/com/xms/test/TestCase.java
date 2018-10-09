package com.xms.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xms.dao.EmpDao;
import com.xms.dao.impl.EmpDaoImpl;
import com.xms.entity.Emp;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestCase {
	//public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
//		List<Emp> empList = dao.findAll();
//		System.out.println(empList.size());
		
//		Emp emp = dao.findByEmpno(1006);
//		System.out.println(emp.getEmpno()+","+emp.getEname());
		//System.out.println(empList.size());
		
//		for(Emp emp : empList){
//			System.out.println(emp.getEmpno()+","+emp.getEname());
//		}
		//增加一个员工
//		Emp emp = new Emp();
//		emp.setEmpno(1015);
//		emp.setEname("张三");
//		emp.setPosition("Clerk");
//		emp.setDeptno(10);
//		emp.setSalary(6000);
//		emp.setBonus(600);
//		emp.setHiredate(new Date());
//		emp.setLeader(1012);
//		dao.saveEmp(emp);
		
//		emp.setEmpno(1015);
//		emp.setEname("李四10");
//		emp.setPosition("Analyst");
//		emp.setDeptno(30);
//		emp.setSalary(7000);
//		emp.setBonus(700);
//		emp.setHiredate(new Date());
//		emp.setLeader(1007);
//		dao.modifyEmp(emp);
		
//		dao.deleteEmp(1015);
//		System.out.println("删除成功");
	//}
		@Test
		public void testFindAll(){
			List<Emp> empList = dao.findAll();
			
			for(Emp emp : empList){
				System.out.println(emp.getEmpno()+","+emp.getEname());
			}
		}
		@Test
		public void testFindOne(){
			Emp emp = dao.findByEmpno(1006);
			System.out.println(emp.getEmpno()+","+emp.getEname());
		}
		@Test
		public void testSave(){
			Emp emp = new Emp();
			emp.setEmpno(1015);
			emp.setEname("张三");
			emp.setPosition("Clerk");
			emp.setDeptno(10);
			emp.setSalary(6000);
			emp.setBonus(600);
			emp.setHiredate(new Date());
			emp.setLeader(1012);
			dao.saveEmp(emp);
			
		}
		@Test
		public void testModify(){
			Emp emp = new Emp();
			emp.setEmpno(1015);
			emp.setEname("李四10");
			emp.setPosition("Analyst");
			emp.setDeptno(30);
			emp.setSalary(7000);
			emp.setBonus(700);
			emp.setHiredate(new Date());
			emp.setLeader(1007);
			dao.modifyEmp(emp);
		}
		@Test
		public void testDelete(){
			dao.deleteEmp(1015);
			System.out.println("删除成功");
		}
}


















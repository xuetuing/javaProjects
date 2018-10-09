package com.xms.test;

import java.util.List;

import org.junit.Test;

import com.xms.dao.EmpPageDao;
import com.xms.dao.impl.EmpPageDaoImpl;
import com.xms.entity.Emp;

public class TestCaseEmpPage {
	EmpPageDao dao = new EmpPageDaoImpl();
	
	@Test
	public void testPageEmpByMysql(){
		List<Emp> list = dao.findPageByMysql(3, 5);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno()+","+emp.getEname());
		}
	}
	
	@Test
	public void testPageEmpByoracle(){
		List<Emp> list = dao.findPageByOracle(2, 5);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno()+","+emp.getEname());
		}
	}
}

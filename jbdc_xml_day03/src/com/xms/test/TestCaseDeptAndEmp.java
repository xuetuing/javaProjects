package com.xms.test;

import org.junit.Test;

import com.xms.dao.DeptAndEmpDao;
import com.xms.dao.impl.DeptAndEmpDaoImpl;
import com.xms.entity.Dept;
import com.xms.entity.Emp;

public class TestCaseDeptAndEmp {
	DeptAndEmpDao dao = new DeptAndEmpDaoImpl();
	@Test
	public void testDeptAndEmp(){
		Dept dept = new Dept();
		dept.setDname("销售部");
		dept.setLocation("广州");
		
		Emp emp = new Emp();
		emp.setEname("李四");
		
		dao.addDeptAndEmp(dept, emp);
	}
}

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
		dept.setDname("���۲�");
		dept.setLocation("����");
		
		Emp emp = new Emp();
		emp.setEname("����");
		
		dao.addDeptAndEmp(dept, emp);
	}
}

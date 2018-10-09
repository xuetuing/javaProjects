package com.xms.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xms.dao.DeptDao;
import com.xms.dao.EmpMapper;
import com.xms.entity.Dept;
import com.xms.entity.Emp;
import com.xms.util.MyBatisUtil;

public class TestCase {
	
	@Test
	public void testOne(){
		DeptDao dao = new DeptDao();
		List<Dept> depts = dao.findAll();
		for(Dept dept : depts){
			System.out.println(dept.getId()+":"+dept.getName()+" "+dept.getAddress());
		}
	}
	@Test
	public void testTwo(){
		SqlSession ss = MyBatisUtil.getSession();
		List<Emp> emps = ss.getMapper(EmpMapper.class).findAll();
		
		for(Emp emp : emps){
			System.out.println(emp.getEname());
		}
	}
}

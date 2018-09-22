package com.xml.test;

import java.util.ArrayList;
import java.util.List;

import com.xml.dao.DeptDao;
import com.xml.dao.impl.DeptDaoImpl;
import com.xml.entity.Dept;

public class TestCase {
	public static void main(String[] args) {
		DeptDao dao = new DeptDaoImpl();
//		List<Dept> deptList = new ArrayList<Dept>();
//		
//		deptList = dao.findAll();
//		for(Dept dept : deptList){
//			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLocation());
//		}
		Dept dept = new Dept();
//		dept = dao.findByDeptno(20);
//		System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLocation());	
		
//		dept.setDeptno(60);
//		dept.setDname("运营部1");
//		dept.setLocation("苏州");
//		dao.savaDept(dept);
//		System.out.println("添加成功！");
//		dao.modifyDept(dept);
//		System.out.println("更新成功！");
		dao.deleteDept(60);
		System.out.println("删除成功！");
	}
}













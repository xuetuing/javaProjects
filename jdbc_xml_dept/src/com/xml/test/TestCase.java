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
//		dept.setDname("��Ӫ��1");
//		dept.setLocation("����");
//		dao.savaDept(dept);
//		System.out.println("��ӳɹ���");
//		dao.modifyDept(dept);
//		System.out.println("���³ɹ���");
		dao.deleteDept(60);
		System.out.println("ɾ���ɹ���");
	}
}













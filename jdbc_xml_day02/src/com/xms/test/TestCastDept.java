package com.xms.test;

import java.util.List;

import org.junit.Test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImlp;
import com.xms.entity.Dept;

/**
 * ������
 * @author Administrator
 *
 */
public class TestCastDept {
	DeptDao dao = new DeptDaoImlp();
	@Test
	public void testFindAll(){
		//���÷���
		List<Dept> deptList = dao.findAll();
		
		for (Dept dept : deptList) {
			System.out.println(dept.getDeptno()+","+dept.getDname()+","+dept.getLocation());
		}
	}
	@Test
	public void testFindOne(){
		Dept dept = dao.findByDeptno(20);
		System.out.println(dept.getDeptno()+","+dept.getDname()+","+dept.getLocation());
	}
	@Test
	public void testSaveDept(){
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("��Ӫ��");
		dept.setLocation("����");
		
		dao.saveDept(dept);
	}
	@Test
	public void testUpdateDept(){
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("�г���");
		dept.setLocation("����");
		
		dao.updateDept(dept);
	}
	@Test
	public void testDeleteDept(){
		dao.deleteDept(50);
	}
}


















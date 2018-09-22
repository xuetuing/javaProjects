package com.xml.dao;

import java.util.List;

import com.xml.entity.Dept;

public interface DeptDao {
	List<Dept> findAll();
	Dept findByDeptno(int deptno);
	void savaDept(Dept dept);
	void modifyDept(Dept dept);
	void deleteDept(int deptno);
}

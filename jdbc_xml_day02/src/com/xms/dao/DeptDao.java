package com.xms.dao;

import java.util.List;

import com.xms.entity.Dept;

public interface DeptDao {
	List<Dept> findAll();
	Dept findByDeptno(int deptno);
	void saveDept(Dept dept);
	void updateDept(Dept dept);
	void deleteDept(int deptno);
}

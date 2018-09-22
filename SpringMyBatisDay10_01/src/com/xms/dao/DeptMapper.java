package com.xms.dao;

import java.util.List;

import com.xms.entity.Admin;
import com.xms.entity.Dept;
import com.xms.entity.MyAnnotation;

@MyAnnotation
public interface DeptMapper {
	Dept findByDeptnoOne(int deptno);
	
	Dept findByDeptnoTwo(int deptno);
	
	List<Admin> findByAdmin();
}

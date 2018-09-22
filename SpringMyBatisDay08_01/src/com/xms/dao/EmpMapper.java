package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

public interface EmpMapper {
	public List<Emp> findAll();
	
	public Emp findByEmpno(int empno);
	
	public void save(Emp emp);
	
	public void update(Emp emp);
	
	public void delete(int empno);
	
}

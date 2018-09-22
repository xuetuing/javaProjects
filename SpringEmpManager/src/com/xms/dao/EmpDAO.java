package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;
import com.xms.entity.User;


public interface EmpDAO {
	
	public List<Emp> findAll() throws Exception;
	
	public Emp findById(int id) throws Exception;
	
	public void add_emp(Emp emp) throws Exception;
	
	public void update_emp(Emp emp) throws Exception;
	
	public void del_emp(int id) throws Exception;
	
	
	
}

package com.xms.dao;

import org.springframework.stereotype.Repository;

import com.xms.entity.Emp;

@Repository
public interface EmpMapper {
	void save(Emp emp);
	
}

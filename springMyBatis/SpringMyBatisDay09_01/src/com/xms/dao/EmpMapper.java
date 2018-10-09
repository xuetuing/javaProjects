package com.xms.dao;

import java.util.List;

import com.xms.entity.Condition;
import com.xms.entity.Emp;
import com.xms.entity.MyAnnotation;

@MyAnnotation
public interface EmpMapper {
	List<Emp> findByDeptno(Condition condition);
	
	List<Emp> findBySalary(Condition condition);
	
	List<Emp> findByDeptnoAndSalary(Condition condition);
	
	void update(Emp emp);
	
	List<Emp> findByEmpno(Condition condition);
}

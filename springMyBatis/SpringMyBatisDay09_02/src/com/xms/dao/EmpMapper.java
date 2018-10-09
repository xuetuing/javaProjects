package com.xms.dao;

import com.xms.entity.Emp;
import com.xms.entity.MyAnnotation;

@MyAnnotation
public interface EmpMapper {
	void save(Emp emp);
}

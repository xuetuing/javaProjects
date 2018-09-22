package com.xms.dao;

import com.xms.entity.Dept;
import com.xms.entity.MyAnnotation;

@MyAnnotation
public interface DeptMapper {
	void save(Dept dept);
}

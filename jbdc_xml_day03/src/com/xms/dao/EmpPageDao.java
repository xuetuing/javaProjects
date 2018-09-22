package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

public interface EmpPageDao {
	//实现oracle的分页
	List<Emp> findPageByOracle(int page,int pageSize);
	//实现mysql分页
	List<Emp> findPageByMysql(int page,int pageSize);
}

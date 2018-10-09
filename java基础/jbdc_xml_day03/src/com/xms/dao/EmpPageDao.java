package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

public interface EmpPageDao {
	//ʵ��oracle�ķ�ҳ
	List<Emp> findPageByOracle(int page,int pageSize);
	//ʵ��mysql��ҳ
	List<Emp> findPageByMysql(int page,int pageSize);
}

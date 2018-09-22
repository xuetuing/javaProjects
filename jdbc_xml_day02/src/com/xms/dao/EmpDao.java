package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

/**
 * 接口：将操作数据库的方法定义在此接口中
 * @author Administrator
 *
 */
public interface EmpDao {
	List<Emp> findAll();
	Emp findByEmpno(int empno);
	void saveEmp(Emp emp);
	void modifyEmp(Emp emp);
	void deleteEmp(int empno);
}








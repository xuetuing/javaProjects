package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

/**
 * �ӿڣ����������ݿ�ķ��������ڴ˽ӿ���
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








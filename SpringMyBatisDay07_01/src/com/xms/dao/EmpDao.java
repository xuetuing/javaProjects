package com.xms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xms.entity.Emp;
import com.xms.util.MyBatisUtil;

public class EmpDao {
	
	public List<Emp> findAll(){
		SqlSession ss = MyBatisUtil.getSession();
		//需要传入的是映射配置文件中的namespace+id,并不是指路径
		List<Emp> emps = ss.selectList("com.xms.dao.EmpDao.findAll");
		ss.close();
		return emps;
	}
	
	public Emp findByEmpno(int empno){
		SqlSession ss = MyBatisUtil.getSession();
		Emp emp = ss.selectOne("com.xms.dao.EmpDao.findByEmpno", empno);
		ss.close();
		return emp;
	}
	
	public void save(Emp emp){
		SqlSession ss = MyBatisUtil.getSession();
		try{
			ss.insert("com.xms.dao.EmpDao.save",emp);
			//事务提交
			ss.commit();
		}catch(Exception e){
			e.printStackTrace();
			//事务回滚
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	public void update(Emp emp){
		SqlSession ss = MyBatisUtil.getSession();
		try{
			ss.update("com.xms.dao.EmpDao.update", emp);
			ss.commit();
		}catch(Exception e){
			e.printStackTrace();
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	public void delete(int empno){
		SqlSession ss = MyBatisUtil.getSession();
		try {
			ss.delete("com.xms.dao.EmpDao.delete",empno);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	//关联查询
	public Map<String,Object> findEmpAndDeptByEmpno(int empno){
		SqlSession ss = MyBatisUtil.getSession();
		Map<String,Object> map = ss.selectOne("com.xms.dao.EmpDao.findEmpAndDeptByEmpno", empno);
		ss.close();
		
		return map;
	}
	//查询所有
	public List<Map<String,Object>> findEmpAndDept(){
		SqlSession ss = MyBatisUtil.getSession();
		List<Map<String,Object>> list = ss.selectList("com.xms.dao.EmpDao.findEmpAndDept");
		ss.close();
		
		return list;
	}
}















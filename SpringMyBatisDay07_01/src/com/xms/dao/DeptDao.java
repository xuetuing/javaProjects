package com.xms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xms.entity.Dept;
import com.xms.util.MyBatisUtil;

public class DeptDao {
	
	public List<Dept> findAll(){
		SqlSession ss = MyBatisUtil.getSession();
		List<Dept> depts = ss.selectList("com.xms.dao.DeptDao.findAll");
		ss.close();
		
		return depts;
	}
	
	public Dept findByDname(String dname){
		SqlSession ss = MyBatisUtil.getSession();
		Dept dept = ss.selectOne("com.xms.dao.DeptDao.findByDname", dname);
		ss.close();
		
		return dept;
	}
	
	public void save(Dept dept){
		SqlSession ss = MyBatisUtil.getSession();
		try {
			ss.insert("com.xms.dao.DeptDao.save", dept);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	public void update(Dept dept){
		SqlSession ss = MyBatisUtil.getSession();
		try {
			ss.update("com.xms.dao.DeptDao.update", dept);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.rollback();
		}finally{
			ss.close();
		}
		
	}
	
	public void delete(int deptno){
		SqlSession ss = MyBatisUtil.getSession();
		try {
			ss.delete("com.xms.dao.DeptDao.delete", deptno);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.rollback();
		}finally{
			ss.close();
		}
		
	}
	
	
	
	
}

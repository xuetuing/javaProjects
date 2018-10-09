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
}

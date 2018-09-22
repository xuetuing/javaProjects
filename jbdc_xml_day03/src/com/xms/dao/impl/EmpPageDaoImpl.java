package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.EmpPageDao;
import com.xms.entity.Emp;
import com.xms.util.DBCPUtil;
import com.xms.util.DBUtil;

public class EmpPageDaoImpl implements EmpPageDao {

	@Override
	public List<Emp> findPageByMysql(int page, int pageSize) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> empList = new ArrayList<Emp>();
		try {
			con = DBCPUtil.getConnection();
			
			String sql = "select * from emp_wang limit ?,?";
			ps = con.prepareStatement(sql);
			int begain = (page -1)*pageSize;
			ps.setInt(1, begain);
			ps.setInt(2, pageSize);
			
			rs = ps.executeQuery();
			Emp emp = null;
			while(rs.next()){
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				if(rs.getDate("hiredate")!=null)
					emp.setHiredate(new Date(rs.getDate("hiredate").getTime()));
				emp.setLeader(rs.getInt("leader"));
				emp.setDeptno(rs.getInt("deptno"));
				
				empList.add(emp);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBCPUtil.releaseConnection(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	@Override
	public List<Emp> findPageByOracle(int page, int pageSize) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> empList = new ArrayList<Emp>();
		try {
			con = DBUtil.getConnection();
			
			String sql = "select * from(select e.*,rownum rn from emp_wang e) where" +
					" rn between ? and ?";
			ps = con.prepareStatement(sql);
			int begain = (page -1)*pageSize + 1;
			int end = page*pageSize;
			ps.setInt(1, begain);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			Emp emp = null;
			while(rs.next()){
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				if(rs.getDate("hiredate")!=null)
					emp.setHiredate(new Date(rs.getDate("hiredate").getTime()));
				emp.setLeader(rs.getInt("leader"));
				emp.setDeptno(rs.getInt("deptno"));
				
				empList.add(emp);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	
	}

}

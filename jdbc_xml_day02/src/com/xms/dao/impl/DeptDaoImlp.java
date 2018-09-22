package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;
import com.xms.util.DBUtil;

public class DeptDaoImlp implements DeptDao {

	@Override
	public void deleteDept(int deptno) {

		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "delete from dept_wang where deptno=?";
			ps = con.prepareStatement(sql);
			
//			String sql = "delete from dept_wang where deptno="+deptno;
			ps.setInt(1, deptno);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(null, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public List<Dept> findAll() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		List<Dept> deptList = new ArrayList<Dept>();
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "select * from dept_wang";
			ps = con.prepareStatement(sql);
//			String sql = "select * from dept_wang";
			rs = ps.executeQuery();
			Dept dept = null;
			while(rs.next()){
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
				deptList.add(dept);
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
		
		return deptList;
	}

	@Override
	public Dept findByDeptno(int deptno) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		Dept dept = null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "select * from dept_wang where deptno=?";
			ps = con.prepareStatement(sql);
//			String sql = "select * from dept_wang where deptno="+deptno;
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			
			if(rs.next()){
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
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
		
		return dept;
	}

	@Override
	public void saveDept(Dept dept) {
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "insert into dept_wang values(?,?,?)";
			ps = con.prepareStatement(sql);
//			String sql = "insert into Dept_wang values("+dept.getDeptno()
//						+",'"+dept.getDname()+"','"+dept.getLocation()+"')";
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLocation());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(null, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public void updateDept(Dept dept) {

		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "update dept_wang set dname=?,location=? where deptno=?";
			ps = con.prepareStatement(sql);
//			String sql = "update dept_wang set dname='"+dept.getDname()+"',location='"
//						+dept.getLocation()+"' where deptno="+dept.getDeptno();
			System.out.println(sql);
			ps.setInt(3, dept.getDeptno());
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLocation());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(null, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	}

}

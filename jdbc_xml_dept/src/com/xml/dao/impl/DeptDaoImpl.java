package com.xml.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xml.dao.DeptDao;
import com.xml.entity.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public void deleteDept(int deptno) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "delete from dept_wang where deptno=" + deptno; 
			
			st.executeQuery(sql);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st !=null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Dept> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Dept> deptList = new ArrayList<Dept>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "select * from dept_wang";
			
			rs = st.executeQuery(sql);
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
				if(rs != null)
					rs.close();
				if(st !=null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptList;
	}

	@Override
	public Dept findByDeptno(int deptno) {
		Connection con = null;
		Statement st = null;
		Dept dept = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "select * from dept_wang where deptno=" + deptno; 
			
			rs = st.executeQuery(sql);
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
				if(st !=null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dept;
	}

	@Override
	public void modifyDept(Dept dept) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "update dept_wang set dname='"+dept.getDname()+"',location='"
						+dept.getLocation()+"' where deptno="+dept.getDeptno(); 
			
			st.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st !=null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void savaDept(Dept dept) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "insert into dept_wang values("+dept.getDeptno()+",'"
						+dept.getDname()+"','"+dept.getLocation()+"')"; 
			
			st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st !=null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
}





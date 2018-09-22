package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xms.dao.DeptAndEmpDao;
import com.xms.entity.Dept;
import com.xms.entity.Emp;
import com.xms.util.DBCPUtil;

public class DeptAndEmpDaoImpl implements DeptAndEmpDao {

	@Override
	public void addDeptAndEmp(Dept dept, Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = DBCPUtil.getConnection();
			con.setAutoCommit(false);
			sql = "insert into dept_wang(dname,location) values(?,?)";
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLocation());
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			int deptno = 0;
			if(rs.next())
				deptno = rs.getInt(1);
			System.out.println("部门主键值:"+deptno);
			//插入员工表
			sql = "insert into emp_wang(ename,deptno) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setInt(2,deptno);
			ps.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				DBCPUtil.releaseConnection(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

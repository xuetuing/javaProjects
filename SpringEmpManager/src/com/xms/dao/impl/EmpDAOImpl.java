package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xms.dao.EmpDAO;
import com.xms.entity.Emp;
import com.xms.entity.User;




@Repository
public class EmpDAOImpl implements EmpDAO{
	@Resource
	private DataSource ds;
	
	public void add_emp(Emp emp) throws Exception {
		Connection con = ds.getConnection();
		String sql = "insert into emp values(null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.executeUpdate();
	}

	public void del_emp(int id) throws Exception {
		Connection con = ds.getConnection();
		String sql = "delete from emp where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}

	public List<Emp> findAll() throws Exception {
		Connection con = ds.getConnection();
		String sql = "select * from emp";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
		while(rs.next()){
			emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setAge(rs.getInt("age"));
			list.add(emp);
		}
		System.out.println(list);
		return list;
	}

	public Emp findById(int id) throws Exception {
		Connection con = ds.getConnection();
		String sql = "select * from emp where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		if(rs.next()){
			emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setAge(rs.getInt("age"));
		}
		return emp;
	}

	public void update_emp(Emp emp) throws Exception {
		Connection con = ds.getConnection();
		String sql = "update emp set name=?,salary=?,age=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getId());
		ps.executeUpdate();
	}
	
}

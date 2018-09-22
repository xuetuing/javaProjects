package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.xms.dao.UserDao;
import com.xms.entity.User;


@Repository
public class UserDaoImpl implements UserDao{
	@Resource
	private DataSource ds;
	public User findByName(String name) throws Exception {
		Connection con = ds.getConnection();
		String sql = "select * from user where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setRealname(rs.getString("realname"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
		}
		return user;
	}
	public void add_user(User user) throws Exception {
		Connection con = ds.getConnection();
		String sql = "insert into user values(null,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,user.getUsername());
		ps.setString(2,user.getRealname());
		ps.setString(3,user.getPassword());
		ps.setString(4,user.getSex());
		ps.executeUpdate();
	}
	
}

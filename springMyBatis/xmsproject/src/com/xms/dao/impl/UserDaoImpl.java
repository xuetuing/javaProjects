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
	
	public User findByName(String email) throws Exception{
		Connection con = ds.getConnection();
		//System.out.println(ds);
		String sql = "select * from xc_user where email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setPassword(rs.getString("password"));
			user.setRegistedate(rs.getDate("registedate"));
		}
		
		return user;
	}
	
}

package com.xms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xms.entity.User;

@Repository
public class UserDao {
	
	@Resource
	private JdbcTemplate jt;
	//根据用户名查找
	public User findByName(String username){
		String sql = "select * from user where username=?";
		//似乎必须查到一个值，不允许null？？
		//加try{}catch{}或定义 一个类继承JdbcTemplate，重写其方法
		User user = null;
		try{
			user = jt.queryForObject(sql, new Object[]{username},new UserRowMapper());
		}catch(Exception e){
			return null;
		}
		
		return user;
	}
	
	
	public void addUser(User user){
	}
	
	class UserRowMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRealname(rs.getString("realname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			return user;
		}
	}
	
	
	
}







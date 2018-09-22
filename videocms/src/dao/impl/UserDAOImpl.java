package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;

import util.DBUtil;
import entity.User;

public class UserDAOImpl implements UserDAO{
	public List<User> findByPage(int page, int pageSize) throws Exception {
		Connection con = DBUtil.getConnection();
		List<User> list = new ArrayList<User>();
		int begin = (page-1)*pageSize;
		String sql = "select * from user limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, begin);
		ps.setInt(2, pageSize);
		
		ResultSet rs = ps.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setRegistdate(rs.getTimestamp("registdate"));
			list.add(user);
			
		}
		DBUtil.close(con);
		return list;
	}

	public int getTotalPages(int pageSize) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select count(1) from user";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt(1);
		int totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(new UserDAOImpl().findByPage(1, 2).size());
//		
//	}
}







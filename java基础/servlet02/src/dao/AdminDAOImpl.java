package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Admin;

public class AdminDAOImpl implements AdminDAO {

	public void add(Admin admin) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into admin values(null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,admin.getUsername());
		ps.setString(2,admin.getPassword());
		ps.setString(3,admin.getRealname());
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public void del(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from admin where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public List<Admin> findAll() throws Exception {
		List<Admin> list = new ArrayList<Admin>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		while(rs.next()){
			admin = new Admin();
			admin.setId(rs.getInt("id"));
			admin.setUsername(rs.getString("username"));
			admin.setPassword(rs.getString("password"));
			admin.setRealname(rs.getString("realname"));
			
			list.add(admin);
		}
		DBUtil.close(con);
		return list;
	}

	public Admin findById(int id) throws Exception {
		Admin admin = null;
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			admin = new Admin();
			admin.setId(rs.getInt("id"));
			admin.setUsername(rs.getString("username"));
			admin.setPassword(rs.getString("password"));
			admin.setRealname(rs.getString("realname"));
		}
		DBUtil.close(con);
		return admin;
	}

	public void update(Admin admin) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "update admin set username=?,password=?,realname=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, admin.getUsername());
		ps.setString(2, admin.getPassword());
		ps.setString(3, admin.getRealname());
		ps.setInt(4, admin.getId());
		ps.executeUpdate();
		DBUtil.close(con);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

}









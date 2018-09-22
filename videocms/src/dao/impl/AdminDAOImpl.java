package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import util.DBUtil;
import dao.AdminDAO;
import entity.Admin;
import entity.Role;

public class AdminDAOImpl implements AdminDAO{

	public List<Admin> findByPage(int page, int pageSize) throws Exception {
		List<Admin> list = new ArrayList<Admin>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page-1)*pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		String sql2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		while(rs.next()){
			admin = new Admin();
			admin.setId(rs.getInt("id"));
			admin.setPassword(rs.getString("password"));
			admin.setUsername(rs.getString("username"));
			admin.setRealname(rs.getString("realname"));
			sql2 = "select r.* from admin_role ar join role r on ar.role_id=r.id where ar.admin_id=?";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, rs.getInt("id"));
			rs2 = ps2.executeQuery();
			List<Role> roles = new ArrayList<Role>();
			while(rs2.next()){
				Role role = new Role();
				role.setId(rs2.getInt("id"));
				role.setName(rs2.getString("name"));
				roles.add(role);
			}
			admin.setRoles(roles);
			list.add(admin);
		}
		
		DBUtil.close(con);
		return list;
	}
//	public static void main(String[] args) throws Exception {
//		System.out.println(new AdminDAOImpl().findByPage(1, 2).get(0).getRoles().get(0).getName());
//	}
	public int getTotalPages(int pageSize) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select count(1) from admin";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt(1);
		int totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}
	
	public List<Role> findAllRoles() throws Exception{
		List<Role> list = new ArrayList<Role>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from role";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Role role = null;
		while(rs.next()){
			role = new Role();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			list.add(role);
		}
		DBUtil.close(con);
		return list;
	}

	public int addAdmin(Admin admin) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into admin values (null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //设置返回自动生成的主键
		ps.setString(1, admin.getUsername());
		ps.setString(2, admin.getPassword());
		ps.setString(3, admin.getRealname());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		DBUtil.close(con);
		return id;
	}
	public void addAdminRole(Map<String, Integer> map) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into admin_role values (null,?,?)";
		PreparedStatement ps = con.prepareStatement(sql); //设置返回自动生成的主键
		ps.setInt(1,map.get("admin_id"));
		ps.setInt(2,map.get("role_id"));
		ps.executeUpdate();
		
		DBUtil.close(con);
	}
	public Admin findById(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		String sql2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		if(rs.next()){
			admin = new Admin();
			admin.setId(id);
			admin.setPassword(rs.getString("password"));
			admin.setUsername(rs.getString("username"));
			admin.setRealname(rs.getString("realname"));
			sql2 = "select r.* from admin_role ar join role r on ar.role_id=r.id where ar.admin_id=?";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1,id);
			rs2 = ps2.executeQuery();
			List<Role> roles = new ArrayList<Role>();
			while(rs2.next()){
				Role role = new Role();
				role.setId(rs2.getInt("id"));
				role.setName(rs2.getString("name"));
				roles.add(role);
			}
			admin.setRoles(roles);
		}
		
		DBUtil.close(con);
		return admin;
	}

	public void delAdminRole(Integer id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from admin_role where admin_id=?";
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setInt(1,id);
		ps.executeUpdate();
		
		DBUtil.close(con);
	}
	public void updateAdmin(Admin admin) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "update admin set username=?,password=?,realname=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,admin.getUsername());
		ps.setString(2,admin.getPassword());
		ps.setString(3,admin.getRealname());
		ps.setInt(4,admin.getId());
		ps.executeUpdate();
		
		DBUtil.close(con);
	}
	public void delAdmin(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from admin where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		
		DBUtil.close(con);
	}
	public Admin findByUsername(String username) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		if(rs.next()){
			admin = new Admin();
			admin.setId(rs.getInt("id"));
			admin.setUsername(rs.getString("username"));
			admin.setRealname(rs.getString("realname"));
			admin.setPassword(rs.getString("password"));
		}
		DBUtil.close(con);
		return admin;
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(new AdminDAOImpl().findByUsername("user01").getUsername());
//	}
}







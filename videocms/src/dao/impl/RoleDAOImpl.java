package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Result;

import util.DBUtil;
import dao.RoleDAO;
import entity.Privilege;
import entity.Role;

public class RoleDAOImpl implements RoleDAO {

	public List<Role> findByPage(int page,int pageSize) throws Exception {
		Connection con = DBUtil.getConnection();
		List<Role> list = new ArrayList<Role>();
		String sql = "select * from role limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		int begin = (page-1)*pageSize;
		ps.setInt(1, begin);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		Role role = null;
		while(rs.next()){
			role = new Role();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			List<Privilege> privs = new ArrayList<Privilege>();
			String sql2 = "select p.* from privilege p join role_priv rp on p.id=rp.priv_id where rp.role_id=?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1,rs.getInt("id"));
			ResultSet rs2 = ps2.executeQuery();
			Privilege priv = null;
			while(rs2.next()){
				priv = new Privilege();
				priv.setId(rs2.getInt("id"));
				priv.setName(rs2.getString("name"));
				privs.add(priv);
			}
			role.setPrivs(privs);
			list.add(role);
		}
		DBUtil.close(con);
		return list;
	}
	
	public int getTotalPages(int pageSize) throws Exception{
		Connection con = DBUtil.getConnection();
		String sql = "select count(1) from role";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt(1);
		int totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}

	public List<Privilege> findAllPrivs() throws Exception {
		Connection con = DBUtil.getConnection();
		List<Privilege> list = new ArrayList<Privilege>(); 
		String sql = "select * from privilege";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Privilege priv = null;
		while(rs.next()){
			priv = new Privilege();
			priv.setId(rs.getInt("id"));
			priv.setName(rs.getString("name"));
			list.add(priv);
		}
		DBUtil.close(con);
		return list;
	}

	public Role findById(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql1 = "select * from role";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ResultSet rs1 = ps1.executeQuery();
		Role role = null;
		if(rs1.next()){
			role = new Role();
			role.setId(rs1.getInt("id"));
			role.setName(rs1.getString("name"));
			String sql2 = "select p.* from privilege p join role_priv rp on p.id=rp.priv_id where rp.role_id=?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, rs1.getInt("id"));
			ResultSet rs2 = ps2.executeQuery();
			List<Privilege> privs = new ArrayList<Privilege>();
			Privilege priv = null;
			while(rs2.next()){
				priv = new Privilege();
				priv.setId(rs2.getInt("id"));
				priv.setName(rs2.getString("name"));
				privs.add(priv);
			}
			role.setPrivs(privs);
		}
		
		DBUtil.close(con);
		return role;
	}

	public void delRoleById(Integer id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from role where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		DBUtil.close(con);
	}

	public int addRole(Role role) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into role values(null,?)";
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,role.getName());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		DBUtil.close(con);
		return id;
	}

	public void addRolePriv(Map<String, Integer> map) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into role_priv values(null,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,map.get("role_id"));
		ps.setInt(2,map.get("priv_id"));
		ps.executeUpdate();
		
		DBUtil.close(con);
	}

	public void updateRole(Role role) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "update role set name=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,role.getName());
		ps.executeUpdate();
		
		DBUtil.close(con);
	}

	public void delRolePriv(Integer id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from role_priv where role_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		
		DBUtil.close(con);
	}


//	public static void main(String[] args) throws Exception {
//		System.out.println(new RoleDAOImpl().findById(1).getPrivs().get(1).getName());
//	}
}




package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Emp;
import entity.User;

public class EmpDAOImpl implements EmpDAO{

	public void add_emp(Emp emp) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into emp values(null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public void add_user(User user) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "insert into user values(null,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,user.getUsername());
		ps.setString(2,user.getRealname());
		ps.setString(3,user.getPassword());
		ps.setString(4,user.getSex());
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public void del_emp(int id) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "delete from emp where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public List<Emp> findAll() throws Exception {
		Connection con = DBUtil.getConnection();
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
		DBUtil.close(con);
		return list;
	}

	public Emp findById(int id) throws Exception {
		Connection con = DBUtil.getConnection();
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
		DBUtil.close(con);
		return emp;
	}

	public User findByUsername(String username) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select * from user where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
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
		DBUtil.close(con);
		return user;
	}

	public void update_emp(Emp emp) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "update emp set name=?,salary=?,age=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getId());
		ps.executeUpdate();
		DBUtil.close(con);
	}
	
}

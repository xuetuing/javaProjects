package com.xms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xms.entity.Dept;

@Repository
public class DeptDao {
	
	@Resource
	JdbcTemplate jdbcTemplate;
	//查询所有部门
	public List<Dept> findAllDept(){
		String sql = "select * from dept";
		
		return jdbcTemplate.query(sql, new DeptRowMapper());
	}
	//根据部门号查询
	public Dept findByDeptno(int deptno){
		String sql = "select * from dept where deptno=?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{deptno}, new DeptRowMapper());
	}
	//增加部门
	public void save(Dept dept){
		String sql = "insert into dept values(?,?,?)";
		Object[] parameters = {dept.getDeptno(),dept.getDname(),dept.getAddress()};
		
		jdbcTemplate.update(sql, parameters);
	}
	//修改部门信息
	public void update(Dept dept){
		String sql = "update dept set dname=?,address=? where deptno=?";
		Object[] parameters = {dept.getDname(),dept.getAddress(),dept.getDeptno()};
		
		jdbcTemplate.update(sql,parameters);
	}
	//删除部门信息
	public void delete(int deptno){
		String sql = "delete from dept where deptno=?";
		
		jdbcTemplate.update(sql,deptno);
	}
	
	class DeptRowMapper implements RowMapper<Dept>{

		public Dept mapRow(ResultSet rs, int index) throws SQLException {
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setAddress(rs.getString("address"));
			
			return dept;
		}
	}
	
}

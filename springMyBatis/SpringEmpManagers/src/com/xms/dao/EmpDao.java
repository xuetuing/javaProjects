package com.xms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xms.entity.Emp;

@Repository
public class EmpDao {
	
	@Resource
	private JdbcTemplate jt;
	
	public List<Emp> findAll(){
		String sql = "select * from emp";
		
		return jt.query(sql, new EmpRowMapper());
	}
	
	public Emp findById(int id){
		String sql = "select * from id=?";
		
		return jt.queryForObject(sql,new Object[]{id},new EmpRowMapper());
	}
	
	public void save(Emp emp){
		
	}
	public void update(Emp emp){
		
	}
	
	public void delete(int id){
		
	}
	
	class EmpRowMapper implements RowMapper<Emp>{

		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setSalary(rs.getDouble("salary"));
			
			return emp;
		}
		
	}
	
	
}

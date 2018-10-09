package com.xms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.xms.entity.Dept;

@Repository
public class DeptDao1 extends JdbcDaoSupport{
//	@Resource
//	public void setDs(DataSource ds){
//		super.setDataSource(ds);
//	}
	
	@Resource
	public void setJt(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}
	
	public List<Dept> findAll(){
		String sql = "select * from dept";
		
		return this.getJdbcTemplate().query(sql, new DeptRowMapper());
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

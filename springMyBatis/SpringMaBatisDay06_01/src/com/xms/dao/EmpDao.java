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
public class EmpDao{
	//@Resource注解，如果没有set方法，会将private改成public或protected，直接给属性赋值
	@Resource
	private JdbcTemplate jdbcTemplate;
	
//	@Resource
//	public void setDs(DataSource ds){
//		super.setDataSource(ds);
//	}
	
	//查询全部员工
	public List<Emp> findAll(){
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, new EmpRowMapper());
	}
	//根据员工号查询员工
	public Emp findByEmpno(int empno){
		String sql = "select * from emp where empno = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{empno}, new EmpRowMapper());
	}
	//添加员工
	public void save(Emp emp){
		String sql = "insert into emp values(?,?,?,?,?,?)";
		Object[] parameters = {
				emp.getEmpno(),emp.getEname(),
				emp.getSalary(),emp.getBonus(),
				emp.getHiredate(),emp.getDeptno()
		};
		jdbcTemplate.update(sql, parameters);
	}
	//修改员工
	public void update(Emp emp){
		String sql = "update emp set ename=?,salary=?,bonus=?,hiredate=?,deptno=? where empno=?";
		Object[] parameters = {
				emp.getEname(),emp.getSalary(),
				emp.getBonus(),emp.getHiredate(),
				emp.getDeptno(),emp.getEmpno()
		};
		
		jdbcTemplate.update(sql,parameters);
	}
	//删除员工
	public void delete(int empno){
		String sql = "delete from emp where empno=?";
		
		jdbcTemplate.update(sql,empno);
		
	}
	
	
	class EmpRowMapper implements RowMapper<Emp>{

		public Emp mapRow(ResultSet rs, int index) throws SQLException {
			
			//index代表结果集中记录的下标，从0开始
			//System.out.println(index);
			
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setBonus(rs.getDouble("bonus"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setDeptno(rs.getInt("deptno"));
			
			return emp;
		}
		
	}
}

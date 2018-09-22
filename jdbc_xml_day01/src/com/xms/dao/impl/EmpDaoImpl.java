package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
/**
 * 实现类：具体事项数据库操作的方法
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//定义集合，存放Emp对象
		List<Emp> emps = new ArrayList<Emp>();
		try {
			//1.加载驱动，建立连接
			//oracle.jdbc.driver.OracleDriver 驱动类的路径
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.创建语句对象
			st = con.createStatement();
			//3.执行sql语句
			String sql = "select * from emp_wang";
			rs = st.executeQuery(sql);
			//4.处理结果集
			Emp emp = null;
			while(rs.next()){
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setLeader(rs.getInt("leader"));
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return emps;
	}

	@Override
	public Emp findByEmpno(int empno) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Emp emp = null;
		//定义集合，存放Emp对象
		try {
			//1.加载驱动，建立连接
			//oracle.jdbc.driver.OracleDriver 驱动类的路径
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.创建语句对象
			st = con.createStatement();
			//3.执行sql语句
			String sql = "select * from emp_wang where empno="+empno;
			rs = st.executeQuery(sql);
			//4.处理结果集
			
			if(rs.next()){
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setLeader(rs.getInt("leader"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	@Override
	public void saveEmp(Emp emp) {
		Connection con = null;
		Statement st = null;
		//加载驱动，建立连接
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.创建语句
			st = con.createStatement();
			//3.执行sql语句   
			//Date 导入sql包
			String sql = "insert into emp_wang emp_wang values("+emp.getEmpno()+",'"+emp.getEname()+"','"
						+emp.getPosition()+"',"+emp.getSalary()+","+emp.getBonus()
						+",to_date('"+new Date(emp.getHiredate().getTime())+"','yyyy-mm-dd'),"
						+emp.getLeader()+","+emp.getDeptno()+")";
			//打印一下sql语句
			System.out.println(sql);
			int num = st.executeUpdate(sql);
			System.out.println("num:"+num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				if(st != null)
					st.close();
				if(con != null)
					con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void modifyEmp(Emp emp) {
		Connection con = null;
		Statement st = null;
		
		try {
			//加载驱动，建立连接
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//写sql语句
			String sql = "update emp_wang set ename='"+emp.getEname()+"',position='"+emp.getPosition()+"',salary="
						+emp.getSalary()+",bonus="+emp.getBonus()+",hiredate=to_date('"+new Date(emp.getHiredate().getTime())
						+"','yyyy-mm-dd'),leader="+emp.getLeader()+",deptno="+emp.getDeptno()+" where empno="+emp.getEmpno();
			st = con.createStatement();
			System.out.println(sql);
			//执行语句
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteEmp(int empno) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			st = con.createStatement();
			String sql = "delete from emp_wang where empno="+empno;
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



















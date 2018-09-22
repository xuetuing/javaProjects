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
 * ʵ���ࣺ�����������ݿ�����ķ���
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//���弯�ϣ����Emp����
		List<Emp> emps = new ArrayList<Emp>();
		try {
			//1.������������������
			//oracle.jdbc.driver.OracleDriver �������·��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.����������
			st = con.createStatement();
			//3.ִ��sql���
			String sql = "select * from emp_wang";
			rs = st.executeQuery(sql);
			//4.��������
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
				//�ر�����
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
		//���弯�ϣ����Emp����
		try {
			//1.������������������
			//oracle.jdbc.driver.OracleDriver �������·��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.����������
			st = con.createStatement();
			//3.ִ��sql���
			String sql = "select * from emp_wang where empno="+empno;
			rs = st.executeQuery(sql);
			//4.��������
			
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
				//�ر�����
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
		//������������������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//2.�������
			st = con.createStatement();
			//3.ִ��sql���   
			//Date ����sql��
			String sql = "insert into emp_wang emp_wang values("+emp.getEmpno()+",'"+emp.getEname()+"','"
						+emp.getPosition()+"',"+emp.getSalary()+","+emp.getBonus()
						+",to_date('"+new Date(emp.getHiredate().getTime())+"','yyyy-mm-dd'),"
						+emp.getLeader()+","+emp.getDeptno()+")";
			//��ӡһ��sql���
			System.out.println(sql);
			int num = st.executeUpdate(sql);
			System.out.println("num:"+num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//�ر�����
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
			//������������������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			//дsql���
			String sql = "update emp_wang set ename='"+emp.getEname()+"',position='"+emp.getPosition()+"',salary="
						+emp.getSalary()+",bonus="+emp.getBonus()+",hiredate=to_date('"+new Date(emp.getHiredate().getTime())
						+"','yyyy-mm-dd'),leader="+emp.getLeader()+",deptno="+emp.getDeptno()+" where empno="+emp.getEmpno();
			st = con.createStatement();
			System.out.println(sql);
			//ִ�����
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



















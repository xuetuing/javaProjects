package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
import com.xms.util.DBUtil;
/**
 * ʵ���ࣺ�����������ݿ�����ķ���
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//���弯�ϣ����Emp����
		List<Emp> emps = new ArrayList<Emp>();
		try {
			//1.������������������
			//oracle.jdbc.driver.OracleDriver �������·��
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			con = DBUtil.getConnection();
			//2.����������
			String sql = "select * from emp_wang";
			ps = con.prepareStatement(sql);//�������ʱԤ����
			//3.ִ��sql���
			//���ִ��ǰ��ֵ��ps.setInt()
			rs = ps.executeQuery();

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
//				if(rs != null)
//					rs.close();
//				if(st != null)
//					st.close();
//				if(con != null)
//					con.close();
				DBUtil.closeConnection(rs, ps, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return emps;
	}

	@Override
	public Emp findByEmpno(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		//���弯�ϣ����Emp����
		try {
			//1.������������������
			//oracle.jdbc.driver.OracleDriver �������·��
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			con = DBUtil.getConnection();
			//2.����������
			String sql = "select * from emp_wang where empno=?";
			ps = con.prepareStatement(sql);
			//3.ִ��sql���
			//ִ��ǰ��ֵ���±��1 ��ʼ
			ps.setInt(1,empno);
			rs = ps.executeQuery();
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
//				if(rs != null)
//					rs.close();
//				if(st != null)
//					st.close();
//				if(con != null)
//					con.close();
				DBUtil.closeConnection(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	@Override
	public void saveEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		//������������������
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			con = DBUtil.getConnection();
			//2.�������
			String sql = "insert into emp_wang values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			//3.ִ��sql���   
			//Date ����sql��
//			String sql = "insert into emp_wang values("+emp.getEmpno()+",'"+emp.getEname()+"','"
//						+emp.getPosition()+"',"+emp.getSalary()+","+emp.getBonus()
//						+",to_date('"+new Date(emp.getHiredate().getTime())+"','yyyy-mm-dd'),"
//						+emp.getLeader()+","+emp.getDeptno()+")";
			//��ӡһ��sql���
			
			System.out.println(sql);
			ps.setInt(1,emp.getEmpno());
			ps.setInt(7,emp.getLeader());
			ps.setInt(8,emp.getDeptno());
			
			ps.setDouble(4, emp.getSalary());
			ps.setDouble(5, emp.getBonus());
			
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getPosition());
			
			ps.setDate(6, new Date(emp.getHiredate().getTime()));
			//ps.setDate(6, emp.getHiredate());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//�ر�����
				DBUtil.closeConnection(null, ps, con);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void modifyEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//������������������
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			con = DBUtil.getConnection();
			//дsql���
//			String sql = "update emp_wang set ename='"+emp.getEname()+"',position='"+emp.getPosition()+"',salary="
//						+emp.getSalary()+",bonus="+emp.getBonus()+",hiredate=to_date('"+new Date(emp.getHiredate().getTime())
//						+"','yyyy-mm-dd'),leader="+emp.getLeader()+",deptno="+emp.getDeptno()+" where empno="+emp.getEmpno();
			String sql = "update emp_wang set ename=?,position=?,salary=?," +
						"bonus=?,hiredate=?,leader=?,deptno=? where empno=?";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			//ִ�����
			ps.setInt(8,emp.getEmpno());
			ps.setInt(6,emp.getLeader());
			ps.setInt(7,emp.getDeptno());
			
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getBonus());
			
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getPosition());
			
			ps.setDate(5, new Date(emp.getHiredate().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(null, ps, con);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteEmp(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
			
			con = DBUtil.getConnection();
			
			String sql = "delete from emp_wang where empno=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(null, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



















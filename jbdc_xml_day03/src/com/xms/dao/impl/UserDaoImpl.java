package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xms.dao.UserDao;
import com.xms.util.DBUtil;

/**
 * ʵ����
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void loginByPreparedStatement(String user, String pwd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "select * from user where username=? and password=?"; 
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loginByStatement(String user, String pwd) {
		//Statement ͨ���û����������ѯ���ݿ⣬�����ѯ���������¼�ɹ�
		//����ʧ��
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			
			st = con.createStatement();
			String sql = "select * from user where username='"
						+user+"' and password='"+pwd+"'";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			if(rs.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(rs, st, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}


















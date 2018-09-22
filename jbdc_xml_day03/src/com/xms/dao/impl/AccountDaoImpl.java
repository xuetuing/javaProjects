package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.xms.dao.AccountDao;
import com.xms.util.DBCPUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void translate(String from, String to, int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBCPUtil.getConnection();			
			//���Զ��ύ��ʽ��Ϊ�ֶ��ύ
			con.setAutoCommit(false);
			//Savepoint sp = con.setSavepoint();
	
			st = con.createStatement();
			String sl = "update account set money=money-"+num+" where id='"+from+"'";
			String s2 = "update account set money=money+"+num+" where id='"+to+"'";
			st.executeUpdate(sl);
			
			//����쳣
			Integer.parseInt("ABC");
			st.executeUpdate(s2);
			//�����ύ
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			//����ع�
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}finally{
			try {
				DBCPUtil.releaseConnection(null, st, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}

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
			//将自动提交方式改为手动提交
			con.setAutoCommit(false);
			//Savepoint sp = con.setSavepoint();
	
			st = con.createStatement();
			String sl = "update account set money=money-"+num+" where id='"+from+"'";
			String s2 = "update account set money=money+"+num+" where id='"+to+"'";
			st.executeUpdate(sl);
			
			//添加异常
			Integer.parseInt("ABC");
			st.executeUpdate(s2);
			//事务提交
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			//事务回滚
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

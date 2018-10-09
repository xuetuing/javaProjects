package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.xms.dao.StudentDao;
import com.xms.util.DBCPUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void deleteBatch() {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBCPUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "delete from student where id=?";
			ps = con.prepareStatement(sql);
			for(int i=1;i<=100;i++){
				
				ps.setInt(1, i);
				ps.addBatch();
			}
			
			ps.executeBatch();
			con.commit();
			ps.clearBatch();
			
		} catch (Exception e) {
		}finally{
			try {
				DBCPUtil.releaseConnection(null, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void saveBatch() {
		Connection con = null;
		Statement st = null;
		String sql = null;
		try {
			con = DBCPUtil.getConnection();
			con.setAutoCommit(false);
			//������
			st = con.createStatement();
			//ѭ����ʽ����������ӵ��������б���
			for(int i=1;i<=100;i++){
				sql = "insert into student values("+i+",'����')";
				st.addBatch(sql);
			}
			
			//������ִ�����
			st.executeBatch();
			//�����ύ
			con.commit();
			//����б�
			st.clearBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBCPUtil.releaseConnection(null, st, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}







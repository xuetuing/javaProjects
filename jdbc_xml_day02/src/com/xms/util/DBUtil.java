package com.xms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * �����ࣺ���ļ���ȡ���ݡ���װ���ӷ�������װ�رշ���
 * @author Administrator
 *
 */
public class DBUtil {
	//���������������
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	//�������ļ��Ķ���
	private static Properties ps = new Properties();
	
	//�������ʱִ�У�ִֻ��һ�Σ����ļ�
	static{
		try {
			//ͨ�����������ȡ������
			//InputStream ins = new FileInputStream(new File("src/db.properties"));
			//ps.load(ins);
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
//			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("oracle.properties"));
			//ͨ��key��ȡ��Ӧ��value
			driver = ps.getProperty("mysql_driver");
			url = ps.getProperty("mysql_url");
			user = ps.getProperty("mysql_user");
			password = ps.getProperty("mysql_pwd");
			
			//��������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}  //�������
	}
	
	//��װ���ӷ���
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	//��װ�رշ���
	public static void closeConnection(ResultSet rs,Statement st,Connection con) throws SQLException{
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
			if(con != null)
				con.close();
	}
	
//	public static void main(String[] args) throws SQLException {
//		System.out.println(getConnection());
//	}
}


















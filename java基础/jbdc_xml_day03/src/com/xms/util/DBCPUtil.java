package com.xms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * �����ࣺ���ļ���ȡ���ݡ���װ���ӷ�������װ�رշ���
 * @author Administrator
 *
 */
public class DBCPUtil {
	//���������������
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	//�������ļ��Ķ���
	private static Properties ps = new Properties();
	
	//BasicDataSource�����ȡ���ݿ�����
	private static BasicDataSource ds = null;
	
	//�������ʱִ�У�ִֻ��һ�Σ����ļ�
	static{
		try {
			//ͨ�����������ȡ������
			//InputStream ins = new FileInputStream(new File("src/db.properties"));
			//ps.load(ins);
			ps.load(DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//ͨ��key��ȡ��Ӧ��value
			driver = ps.getProperty("mysql_driver");
			url = ps.getProperty("mysql_url");
			user = ps.getProperty("mysql_user");
			password = ps.getProperty("mysql_pwd");
			
			//��ȡ���ӳ���ز���
			String initialSize = ps.getProperty("dataSource.initialSize");
			String maxActive = ps.getProperty("dataSource.maxActive");
			String maxIdle = ps.getProperty("dataSource.maxIdle");
			String minIdle = ps.getProperty("dataSource.minIdle");
			String maxWait = ps.getProperty("dataSource.maxWait");
			
			ds = new BasicDataSource();
			//�����ݿ⡢���ӳ���ز������õ�ds������
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			
			if(initialSize!=null)
				ds.setInitialSize(Integer.parseInt(initialSize));
			if(maxActive!=null)
				ds.setMaxActive(Integer.parseInt(maxActive));
			if(maxIdle!=null)
				ds.setMaxIdle(Integer.parseInt(maxIdle));
			if(minIdle!=null)
				ds.setMinIdle(Integer.parseInt(minIdle));
			if(maxWait!=null)
				ds.setMaxWait(Long.parseLong(maxWait));
			
//			//��������
//			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}  //�������
	}
	
	//��װ���ӷ���
	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection(url, user, password);
		Connection con = null;
		if(ds!=null)
			con = ds.getConnection();
		return con;
	}
	//��װ�黹����
	public static void releaseConnection(ResultSet rs,Statement st,Connection con) throws SQLException{
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


















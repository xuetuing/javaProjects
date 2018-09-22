package com.xms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类：读文件、取数据、封装连接方法、封装关闭方法
 * @author Administrator
 *
 */
public class DBUtil {
	//定义变量接收数据
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	//创建读文件的对象
	private static Properties ps = new Properties();
	
	//在类加载时执行，只执行一次，读文件
	static{
		try {
			//通过类加载器获取输入流
			//InputStream ins = new FileInputStream(new File("src/db.properties"));
			//ps.load(ins);
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
//			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("oracle.properties"));
			//通过key获取对应的value
			driver = ps.getProperty("mysql_driver");
			url = ps.getProperty("mysql_url");
			user = ps.getProperty("mysql_user");
			password = ps.getProperty("mysql_pwd");
			
			//加载驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}  //类加载器
	}
	
	//封装连接方法
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	//封装关闭方法
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


















package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;
	
	private static Properties ps = new Properties();
	
	static{
		try {
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("DB.properties"));
			driver = ps.getProperty("driver");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			pwd = ps.getProperty("pwd");
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public static void close(Connection con) throws SQLException{
		if(con!=null)
			con.close();
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(getConnection());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}














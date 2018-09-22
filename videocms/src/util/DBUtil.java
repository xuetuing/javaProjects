package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DBUtil {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	private static Properties ps = new Properties();
	static{
		try {
			//需要放在静态块中
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("DB.properties"));
			
			driver = ps.getProperty("Driver");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("pwd");
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	public static void close(Connection con)throws SQLException{
		if(con!=null)
			con.close();	
	}
//	public static void psAssignment(List list,PreparedStatement ps){
//		//依次赋值
//		
//	}
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}











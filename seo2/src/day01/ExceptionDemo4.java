package day01;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		connectDB("admin","12356");
		System.out.println("恭喜登录成功");
	}
	
	public static void connectDB(String user,String pwd){
		if("admin".equals(user)&&"123456".equals(pwd)){
			System.out.println("连接数据库成功");
		}else{
			//模拟系统抛出一个连接数据库失败的异常 
			throw new RuntimeException("数据库连接失败");
		}
	}
	
	
}

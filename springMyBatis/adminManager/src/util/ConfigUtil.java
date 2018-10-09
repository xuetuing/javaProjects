package util;

import java.util.Properties;

public class ConfigUtil {
	private static Properties p = new Properties();
	static{
		try {
			//InputStream ins = new FileInputStream(new File("")); 此种方式从工程目录下开始找
			p.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//根据key获取value值
	public static String getValue(String key){
		return p.getProperty(key);
	}
//	public static void main(String[] args) {
//		System.out.println(getValue("AdminDAO"));
//	}
}

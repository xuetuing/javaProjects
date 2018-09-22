package util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static String key;
	
	private static Properties ps = new Properties();
	
	static{
		try {
			ps.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return ps.getProperty(key);
	}
}

package util;

import java.util.Properties;

public class ConfigUtil {
	private static Properties p = new Properties();
	static{
		try {
			//InputStream ins = new FileInputStream(new File("")); ���ַ�ʽ�ӹ���Ŀ¼�¿�ʼ��
			p.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//����key��ȡvalueֵ
	public static String getValue(String key){
		return p.getProperty(key);
	}
//	public static void main(String[] args) {
//		System.out.println(getValue("AdminDAO"));
//	}
}

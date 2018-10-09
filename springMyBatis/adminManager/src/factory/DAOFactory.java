package factory;

import util.ConfigUtil;

//返回符合DAO接口要求的对象
public class DAOFactory {
	//type:接口类型
	public static Object getInstance(String type){
		Object obj = null;
		String className = ConfigUtil.getValue(type);
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
		
	}
	
//	public static void main(String[] args) {
//		Object obj = getInstance("AdminDAO");
//		System.out.println(obj);
//	}
	
}

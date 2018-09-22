package factory;

import util.ConfigUtil;

public class DAOFactory {
	
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
}

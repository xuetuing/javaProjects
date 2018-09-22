package factory;

import util.ConfigUtil;

//���ط���DAO�ӿ�Ҫ��Ķ���
public class DAOFactory {
	//type:�ӿ�����
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

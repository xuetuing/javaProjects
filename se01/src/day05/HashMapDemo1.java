package day05;

import java.util.HashMap;
import java.util.Map;

//Map���Ǽ���
public class HashMapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
//		int num = map.put("one", 1);
		Integer num = map.put("one", 1);
		System.out.println(map);
		System.out.println(num); //��ָ���쳣
		map.put("one", 1);
		map.put("one", 1);
		map.put("three", 3);
		map.put("four", 4);
//		System.out.println(map.size());
//		System.out.println(map);
//		
//		int num = map.put("one", 100);
//		System.out.println(num);
//		System.out.println(map);
		
		int v = map.get("one");
		System.out.println(v);
		
		/*
		 * ʹ��MapʱҪע��
		 * ������value��������8���������͵İ�װ��ʱ�����ܷ���ֵ
		 * Ҫ���null������������Ϊ�Զ���װ�������Ŀ�ָ���쳣
		 */
		Integer m = map.get("five");
		System.out.println(m);
		
		/*
		 * boolean containsKey(Object k)
		 * boolean containsValue(Object v)
		 * �鿴������key/value�Ƿ������Map��
		 */
		System.out.println(map.containsKey("five"));
		System.out.println(map.containsValue(1));
		
		
	}
	
}




















package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//����Map
public class HashMapDemo3 {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		String str = map.put(null, "one");
		map.put(1, "one"); //��������ͬ�ļ�ֵ��ʱ���������ؾ�ֵ
		//System.out.println(str);
		map.put(3, "three");
		map.put(4, "four");
		
		str = map.get(null);
		System.out.println(str);//key��nullʱҲ����ȡ����ֵ
		/*
		 * �������е�key
		 * Set keySet()
		 */
		Set<Integer> keySet = map.keySet();
		for(int key : keySet){
			System.out.println(key);
		}
		/*
		 * �������еļ�ֵ��
		 * ÿһ���ֵ��ʹ��һ��Entry���ʵ��������
		 * Set entrySet()
		 * Entry:Ҫ������������˵���������ļ�ֵ�Ե�key��value������
		 * ����ͨ��ʹ��Map�ķ���
		 */
//		Set<Entry<Integer,String>> entrySet = map.entrySet();
//		for(Entry<Integer,String> entry : entrySet){
//			System.out.println(entry);
			/*
			 * Entry�е�����������getKey()��getValue()
			 */
//			int key = entry.getKey();
//			String value = entry.getValue();
//			System.out.println(key+":"+value);
//		}
		/*
		 * �������е�value
		 * Collection values()
		 */
//		Collection<String> values = map.values();
//		for(String value : values){
//			System.out.println(value);
//		}
		
		
	}
}





















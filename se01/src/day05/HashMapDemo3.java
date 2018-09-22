package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//遍历Map
public class HashMapDemo3 {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		String str = map.put(null, "one");
		map.put(1, "one"); //当插入相同的键值对时，方法返回就值
		//System.out.println(str);
		map.put(3, "three");
		map.put(4, "four");
		
		str = map.get(null);
		System.out.println(str);//key是null时也可以取出其值
		/*
		 * 遍历所有的key
		 * Set keySet()
		 */
		Set<Integer> keySet = map.keySet();
		for(int key : keySet){
			System.out.println(key);
		}
		/*
		 * 遍历所有的键值对
		 * 每一组键值对使用一个Entry类的实例来描述
		 * Set entrySet()
		 * Entry:要求定义两个泛型说明其描述的键值对的key和value的类型
		 * 这里通常使用Map的泛型
		 */
//		Set<Entry<Integer,String>> entrySet = map.entrySet();
//		for(Entry<Integer,String> entry : entrySet){
//			System.out.println(entry);
			/*
			 * Entry中的两个方法：getKey()和getValue()
			 */
//			int key = entry.getKey();
//			String value = entry.getValue();
//			System.out.println(key+":"+value);
//		}
		/*
		 * 遍历所有的value
		 * Collection values()
		 */
//		Collection<String> values = map.values();
//		for(String value : values){
//			System.out.println(value);
//		}
		
		
	}
}





















package day05;

import java.util.HashMap;
import java.util.Map;

//Map不是集合
public class HashMapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
//		int num = map.put("one", 1);
		Integer num = map.put("one", 1);
		System.out.println(map);
		System.out.println(num); //空指针异常
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
		 * 使用Map时要注意
		 * 若我们value的类型是8个基本类型的包装类时，接受返回值
		 * 要针对null做处理，避免因为自动拆装箱引发的空指针异常
		 */
		Integer m = map.get("five");
		System.out.println(m);
		
		/*
		 * boolean containsKey(Object k)
		 * boolean containsValue(Object v)
		 * 查看给定的key/value是否包含在Map中
		 */
		System.out.println(map.containsKey("five"));
		System.out.println(map.containsValue(1));
		
		
	}
	
}




















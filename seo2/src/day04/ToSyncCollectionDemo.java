package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//利用Collections将线程不安全集合转换为线程安全的集合
public class ToSyncCollectionDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * 将ArrayList转换为一个线程安全的集合，原集合中的
		 * 元素依然保留
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		Set<String> set = new HashSet<String>();
		set = Collections.synchronizedSet(set);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map = Collections.synchronizedMap(map);
		
		
		
		
 	}
}
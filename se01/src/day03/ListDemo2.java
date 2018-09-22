package day03;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();
		//对于List集合来说，add()是向集合末尾追加元素
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * Object get(int index)
		 * 获取当前集合中给定下标的元素
		 */
		Object obj = list.get(1);
		System.out.println(obj);
		//通过get()方法来遍历集合元素
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		/*
		 * Object set(int index ,Object o)
		 * 将集合中给定位置的元素替换为给定元素，返回被替换的元素
		 */
		Object replace = list.set(2,"三");
		System.out.println(replace);
		System.out.println(list);
	}
}























package day03;

import java.util.ArrayList;
import java.util.List;

/*
 * List接口是Collection派生出的子接口
 * 用于标示该种集合为可重复集、
 * 通常List集合是有序集，允许通过下标的形式访问集合元素
 */
public class ListDemo {
	public static void main(String[] args) {
//		List list = new LinkedList();
//		List list = new Vector();
		List list = new ArrayList();
		//对于List集合来说，add()是向集合末尾追加元素
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("one");
		System.out.println(list);
		/*
		 * void add(int index,E e)
		 * 将给定的元素插入到给定的位置
		 * 
		 */
		System.out.println(list.get(1));
		list.add(2,"二");
		System.out.println(list);
		//remove(object obj)  remove(int index)
		list.remove("two");
		Object remove = list.remove(1);//会返回删除的元素
		/*
		 * List独有的方法
		 * int indexOf(object o)
		 * 查看给定元素在集合中的下标
		 * 若集合中不包含该元素，则返回-1
		 */
		int index = list.indexOf("one");
		System.out.println(index);
		index = list.lastIndexOf("one");
		System.out.println(index);
		
		
	}
}	


























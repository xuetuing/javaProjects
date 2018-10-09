package day04;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		/*
		 * Object[] toArray() -->Collection接口中定义
		 * 该方法用于将集合转换为数组
		 */
		Object[] array = list.toArray();
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		/*
		 * 重载的toArray()方法：允许直接转换为一个具体类型的数组
		 * 注意：1.保证传入的数组类型与集合中存放的元素类型一致
		 * 2.强转时要注意转换的数组类型
		 * 3.通常传入的数组不需要给定长度
		 */
		String[] strArray = (String[])list.toArray(new String[0]);
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		
		
	}
	
	
}

package day04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 迭代器支持泛型并且迭代器的泛型与其遍历的集合的
 * 类型一致
 */
public class Demo4 {
	public static void main(String[] args) {
		List<String> list = new ArrayList();

		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		
	}
}
































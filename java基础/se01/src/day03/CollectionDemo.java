package day03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		//ArrayList内部由一个数组对象实现的
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		Collection c3 = new ArrayList();
		
		c1.add("one");
		c1.add("two");
		c1.add("three");
//		c1.add(1);
		c2.add("four");
		c2.add("five");
		
		c3.add("one");
		c3.add("two");
		
		System.out.println(c1.size());
		System.out.println(c1.contains("one"));
		//c1.clear();
		//System.out.println(c1.remove("one"));
		c1.addAll(c2);
		c1.removeAll(c3);
		c1.retainAll(c2);
		//以上判断的“相同”，都是使用的元素的equals()作为标准
		System.out.println(c1);
		
		
		
		
		
	}
}







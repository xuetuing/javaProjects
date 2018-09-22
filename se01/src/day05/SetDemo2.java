package day05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//遍历Set集合
public class SetDemo2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//Set存储依赖hashCode()
		set.add("one");
		set.add("two");
		set.add("three");
		//迭代器遍历
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//foreach循环
		for(String str : set){
			System.out.println(str);
		}
		
		
		
	}
	
}

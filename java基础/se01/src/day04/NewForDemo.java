package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NewForDemo {
	public static void main(String[] args) {
		String[] array = {"a","b","c","d","e","f",};
		//传统方式
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		for(String str : array){
			System.out.println(str);
		}
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
		for(int i=0;i<c.size();i++){
			//System.out.println(((List<String>)c).get(i));
			System.out.println(((ArrayList<String>)c).get(i));
		}
		
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		/*
		 * 新循环底层就是使用迭代器实现的
		 * java在编译时，会将新循环转换为迭代器模式，
		 * 不可在迭代时增删元素
		 */
		for(String str : c){   
			System.out.println(str);
		}
		
	}
}
















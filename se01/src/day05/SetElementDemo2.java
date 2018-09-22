package day05;

import java.util.HashSet;
import java.util.Set;
/*
 * 当一个元素存入HashSet集合后，尽量不要使用该元素的hashCode()
 * 再使用该元素的hashCode()返回值会发生变化，降低散列表的性能
 */
public class SetElementDemo2 {
	public static void main(String[] args) {
		Set<Element> set = new HashSet<Element>();
		Element e = new Element(1);
		set.add(e);
		e.setX(2);
		set.add(e);
		e.setX(3);
		set.add(e);//加入的3个值是同一个对象，由同一个hashCode()得到的hash值
		System.out.println(set.size());
		System.out.println(set);
		
		set.remove(e);//删除一个，指针被删除
		System.out.println(set.size());
		System.out.println(set);
		
		set.remove(e);//此次无法删除第二个
		System.out.println(set.size());
		System.out.println(set);
		
		e.setX(2);
		set.remove(e);
		System.out.println(set.size());
		System.out.println(set);
		
	}
}








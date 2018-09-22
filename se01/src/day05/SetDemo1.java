package day05;

import java.util.HashSet;
import java.util.Set;

//Set集合的无序和不重复
public class SetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//Set存储依赖hashCode()
		set.add("one");
		set.add("two");
		set.add("three");
		/*
		 * 元素存放 顺序与元素在集合内部保存的位置不一致
		 * 只要元素内容不变，无论哪个元素先放入集合，集合内部存放元素
		 * 的顺序不变
		 */
		System.out.println(set.size());
		System.out.println(set);
		//Set集合不能存入重复的元素
		System.out.println(set.add("one"));
	}
}


















































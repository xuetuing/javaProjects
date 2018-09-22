package day04;

import java.util.ArrayList;
import java.util.List;

/*
 * 集合支持泛型
 * 泛型指定的是集合中元素的类型
 */
public class Demo2 {
	public static void main(String[] args) {
		List<String> c1 = new ArrayList<String>();
		List c2 = new ArrayList();
		
		c1.add(" one ");
		//c1.add(2);
		c1.add(" two ");
		c1.add(" three ");
		
		c2.add("  one  ");
		c2.add("  two  ");
		c2.add("  three  ");
		
		//遍历集合
		for(int i=0;i<c1.size();i++){
			System.out.println(c1.get(i).trim());
		}
		for(int i=0;i<c2.size();i++){
			System.out.println(((String)c2.get(i)).trim());
		}
		
		List l = c1;
		l.add(4);//整型
		System.out.println(c1);
		for(int i=0;i<c1.size();i++){
			System.out.println(c1.get(i));//遍历到4时会发生类转换异常
		}
	}
}



















































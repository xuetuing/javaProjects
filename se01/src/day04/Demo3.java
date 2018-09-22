package day04;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * 遍历集合元素通用方式：迭代器模式
 */
public class Demo3 {
	public static void main(String[] args) {
		Collection c = new LinkedList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add(null);
		
		/*
		 * Iterator是一个接口
		 * 不同的集合返回的迭代器实现的不尽相同
		 */
		Iterator it = c.iterator();
		System.out.println(it);
		/*
		 * 注意：使用迭代器遍历集合的顺序必须遵循：问取删（删除不是必须的）
		 * 问：boolean hasnext():查看当前集合是否还有元素可以遍历
		 * 取：Object next():取出一个元素
		 * 删：void remove():删除通过next()方法遍历出的元素
		 */
		while(it.hasNext()){
			Object obj = it.next();
//			if(obj.equals("#")){  //在遍历到"null"时，出现空指针异常，原因是equals()
//				it.remove();
//			}
			if("#".equals(obj)){ //正确写法
				it.remove();
			}
			//it.remove();//remove()在每次调用next()方法后只能调用一次
			//it.remove();
			//c.remove(obj);迭代器要求，在迭代过程中不允许通过集合删除元素
			System.out.println(obj);
		}
		System.out.println(c);
		
	}
}










































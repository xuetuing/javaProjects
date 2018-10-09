package day04;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * 双端队列：该队列两端都可以出队入队
 * 当我们只从一端操作时，是实现了经典的数据结构：栈（FILO）
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void push(E e)
		 * 向栈中"压入"元素		入栈操作
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push(null);
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.peekFirst());
		/*
		 * E pop()  获取栈顶元素
		 * 当获取栈顶元素后，该元素从栈中被移除
		 * 当栈中不包含该元素时，调用该方法会抛出异常
		 */
//		for(int i=stack.size();i>0;i--){
//			System.out.println(stack.pop());
//		}
		Iterator it = stack.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}
}




























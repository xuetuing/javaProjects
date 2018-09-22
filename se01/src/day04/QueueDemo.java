package day04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//队列必须要遵循先进先出
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer(null);
		System.out.println(queue);
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		/*
		 * 如果队列中不包含任何元素，poll()返回null
		 */
//		String str = null;
//		while((str=queue.poll())!=null){
//			System.out.println(str);
//		}
//		for(int i=1;i<queue.size();i++){
//			System.out.println(queue.poll());
//		}
		/*
		 * 若想控制循环次数，一定要保证循环条件参与的数据不能发生变化
		 * 否则不能保证循环次数，对于遍历集合或队列，若循环中集合或
		 * 队列的元素发生变化，那么我们应当“倒着循环”
		 */
//		for(int i=queue.size();i>0;i--){
//			System.out.println(queue.poll());
//		}
//		Iterator it = queue.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		for(String str : queue){
			System.out.println(str);
		}
		
		
	}
}


















package day04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//���б���Ҫ��ѭ�Ƚ��ȳ�
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
		 * ��������в������κ�Ԫ�أ�poll()����null
		 */
//		String str = null;
//		while((str=queue.poll())!=null){
//			System.out.println(str);
//		}
//		for(int i=1;i<queue.size();i++){
//			System.out.println(queue.poll());
//		}
		/*
		 * �������ѭ��������һ��Ҫ��֤ѭ��������������ݲ��ܷ����仯
		 * �����ܱ�֤ѭ�����������ڱ������ϻ���У���ѭ���м��ϻ�
		 * ���е�Ԫ�ط����仯����ô����Ӧ��������ѭ����
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


















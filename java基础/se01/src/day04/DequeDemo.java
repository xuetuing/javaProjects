package day04;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * ˫�˶��У��ö������˶����Գ������
 * ������ֻ��һ�˲���ʱ����ʵ���˾�������ݽṹ��ջ��FILO��
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void push(E e)
		 * ��ջ��"ѹ��"Ԫ��		��ջ����
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
		 * E pop()  ��ȡջ��Ԫ��
		 * ����ȡջ��Ԫ�غ󣬸�Ԫ�ش�ջ�б��Ƴ�
		 * ��ջ�в�������Ԫ��ʱ�����ø÷������׳��쳣
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




























package day03;

import java.util.ArrayList;
import java.util.List;

/*
 * List�ӿ���Collection���������ӽӿ�
 * ���ڱ�ʾ���ּ���Ϊ���ظ�����
 * ͨ��List���������򼯣�����ͨ���±����ʽ���ʼ���Ԫ��
 */
public class ListDemo {
	public static void main(String[] args) {
//		List list = new LinkedList();
//		List list = new Vector();
		List list = new ArrayList();
		//����List������˵��add()���򼯺�ĩβ׷��Ԫ��
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("one");
		System.out.println(list);
		/*
		 * void add(int index,E e)
		 * ��������Ԫ�ز��뵽������λ��
		 * 
		 */
		System.out.println(list.get(1));
		list.add(2,"��");
		System.out.println(list);
		//remove(object obj)  remove(int index)
		list.remove("two");
		Object remove = list.remove(1);//�᷵��ɾ����Ԫ��
		/*
		 * List���еķ���
		 * int indexOf(object o)
		 * �鿴����Ԫ���ڼ����е��±�
		 * �������в�������Ԫ�أ��򷵻�-1
		 */
		int index = list.indexOf("one");
		System.out.println(index);
		index = list.lastIndexOf("one");
		System.out.println(index);
		
		
	}
}	


























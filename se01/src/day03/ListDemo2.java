package day03;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();
		//����List������˵��add()���򼯺�ĩβ׷��Ԫ��
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		/*
		 * Object get(int index)
		 * ��ȡ��ǰ�����и����±��Ԫ��
		 */
		Object obj = list.get(1);
		System.out.println(obj);
		//ͨ��get()��������������Ԫ��
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		/*
		 * Object set(int index ,Object o)
		 * �������и���λ�õ�Ԫ���滻Ϊ����Ԫ�أ����ر��滻��Ԫ��
		 */
		Object replace = list.set(2,"��");
		System.out.println(replace);
		System.out.println(list);
	}
}























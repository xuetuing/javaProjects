package day04;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		/*
		 * Object[] toArray() -->Collection�ӿ��ж���
		 * �÷������ڽ�����ת��Ϊ����
		 */
		Object[] array = list.toArray();
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		/*
		 * ���ص�toArray()����������ֱ��ת��Ϊһ���������͵�����
		 * ע�⣺1.��֤��������������뼯���д�ŵ�Ԫ������һ��
		 * 2.ǿתʱҪע��ת������������
		 * 3.ͨ����������鲻��Ҫ��������
		 */
		String[] strArray = (String[])list.toArray(new String[0]);
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		
		
	}
	
	
}

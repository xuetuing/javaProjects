package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NewForDemo {
	public static void main(String[] args) {
		String[] array = {"a","b","c","d","e","f",};
		//��ͳ��ʽ
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		for(String str : array){
			System.out.println(str);
		}
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
		for(int i=0;i<c.size();i++){
			//System.out.println(((List<String>)c).get(i));
			System.out.println(((ArrayList<String>)c).get(i));
		}
		
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		/*
		 * ��ѭ���ײ����ʹ�õ�����ʵ�ֵ�
		 * java�ڱ���ʱ���Ὣ��ѭ��ת��Ϊ������ģʽ��
		 * �����ڵ���ʱ��ɾԪ��
		 */
		for(String str : c){   
			System.out.println(str);
		}
		
	}
}
















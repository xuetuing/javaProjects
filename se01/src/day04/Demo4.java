package day04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * ������֧�ַ��Ͳ��ҵ������ķ�����������ļ��ϵ�
 * ����һ��
 */
public class Demo4 {
	public static void main(String[] args) {
		List<String> list = new ArrayList();

		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		
	}
}
































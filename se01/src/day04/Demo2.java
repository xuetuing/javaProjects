package day04;

import java.util.ArrayList;
import java.util.List;

/*
 * ����֧�ַ���
 * ����ָ�����Ǽ�����Ԫ�ص�����
 */
public class Demo2 {
	public static void main(String[] args) {
		List<String> c1 = new ArrayList<String>();
		List c2 = new ArrayList();
		
		c1.add(" one ");
		//c1.add(2);
		c1.add(" two ");
		c1.add(" three ");
		
		c2.add("  one  ");
		c2.add("  two  ");
		c2.add("  three  ");
		
		//��������
		for(int i=0;i<c1.size();i++){
			System.out.println(c1.get(i).trim());
		}
		for(int i=0;i<c2.size();i++){
			System.out.println(((String)c2.get(i)).trim());
		}
		
		List l = c1;
		l.add(4);//����
		System.out.println(c1);
		for(int i=0;i<c1.size();i++){
			System.out.println(c1.get(i));//������4ʱ�ᷢ����ת���쳣
		}
	}
}



















































package day05;

import java.util.HashSet;
import java.util.Set;
/*
 * ��һ��Ԫ�ش���HashSet���Ϻ󣬾�����Ҫʹ�ø�Ԫ�ص�hashCode()
 * ��ʹ�ø�Ԫ�ص�hashCode()����ֵ�ᷢ���仯������ɢ�б������
 */
public class SetElementDemo2 {
	public static void main(String[] args) {
		Set<Element> set = new HashSet<Element>();
		Element e = new Element(1);
		set.add(e);
		e.setX(2);
		set.add(e);
		e.setX(3);
		set.add(e);//�����3��ֵ��ͬһ��������ͬһ��hashCode()�õ���hashֵ
		System.out.println(set.size());
		System.out.println(set);
		
		set.remove(e);//ɾ��һ����ָ�뱻ɾ��
		System.out.println(set.size());
		System.out.println(set);
		
		set.remove(e);//�˴��޷�ɾ���ڶ���
		System.out.println(set.size());
		System.out.println(set);
		
		e.setX(2);
		set.remove(e);
		System.out.println(set.size());
		System.out.println(set);
		
	}
}








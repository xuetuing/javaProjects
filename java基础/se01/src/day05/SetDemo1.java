package day05;

import java.util.HashSet;
import java.util.Set;

//Set���ϵ�����Ͳ��ظ�
public class SetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//Set�洢����hashCode()
		set.add("one");
		set.add("two");
		set.add("three");
		/*
		 * Ԫ�ش�� ˳����Ԫ���ڼ����ڲ������λ�ò�һ��
		 * ֻҪԪ�����ݲ��䣬�����ĸ�Ԫ���ȷ��뼯�ϣ������ڲ����Ԫ��
		 * ��˳�򲻱�
		 */
		System.out.println(set.size());
		System.out.println(set);
		//Set���ϲ��ܴ����ظ���Ԫ��
		System.out.println(set.add("one"));
	}
}


















































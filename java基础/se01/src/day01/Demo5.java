package day01;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		String str = "Thinking in java";
		String sub = str.substring(9, 11);
		//System.out.println(sub);
		
		sub = str.substring(12);
		//System.out.println(sub);
		
		String str1 = "��ָ��λ�ÿ�ʼ";
		char[] chs = str1.toCharArray();
		//System.out.println(chs);//�ַ���
		System.out.println(chs.toString());//��ַ
		//System.out.println(Arrays.toString(chs));//����
		//str = Arrays.toString(chs);//���ص����ݻ����"[]"
		String str2 = new String(chs);
		System.out.println(str2);
		
		
	}
}





















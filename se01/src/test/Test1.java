package test;

import java.util.Date;

public class Test1 extends Date{
	public static void main(String[] args) {
		//new Test1().test();
		
		//�ַ����ӷ������ڱ��������Ż�
		String s1 = "a";
		String s2 = s1 + "b";  //�������¶���
		String s3 = "a" + "b";  
		String s4 = "ab";
		System.out.println(s1=="a"); //true
		System.out.println(s2=="ab"); //false����������ĵ�ַ�ǲ�һ����
		System.out.println(s3=="ab"); //true  �������Ż���û�д����¶���
		System.out.println(s2==s3);  //false
		System.out.println(s3==s4); // true
		
	}
	public void test(){
		//���� getClass()�� Object���ж������ final�����಻�ܸ��Ǹ÷���
		System.out.println(super.getClass().getName());
		System.out.println(getClass().getSuperclass().getName());
		
	}
}

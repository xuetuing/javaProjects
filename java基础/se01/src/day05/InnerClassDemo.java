package day05;

import day05.Goo.Moo;

//��Ա�ڲ���
public class InnerClassDemo {
	public static void main(String[] args) {
		//��Ա��������Ҫ��ʵ�����ܵ���
//		Moo moo = new Moo();
		Goo goo = new Goo();
		//����ʹ��gooʵ�����ܴ���Moo����
		Moo moo = goo.new Moo();  //��д�ص�
		//goo������Mooʵ�����Է���gooʵ��������
		System.out.println(moo.add());
		
		Goo goo2 = new Goo();
		goo2.a = 2;
		Moo moo2 = goo2.new Moo();
		System.out.println(moo2.add());
	}
}
/*
 * Moo����Goo�ĳ�Ա�ڲ��࣬������ͨ�ڲ���
 * ��Ա�ڲ�����ʵ������������ͬ��������
 */
class Goo{
	int a = 1;
	static int b = 2;
	class Moo{
		//��Ա�ڲ�����ŵ㣺���Թ����ⲿ��ĳ�Ա����
		int add(){
			return a+b;
		}
	}
}
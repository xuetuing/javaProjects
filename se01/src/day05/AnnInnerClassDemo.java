package day05;

public class AnnInnerClassDemo {
	public static void main(String[] args) {
		/*
		 *�����ڲ��ࣺ
		 *new Xoo(){}�Ƕ�Xoo�ļ̳У�����ʵ����
		 *new Xoo(){}��Xoo������ʵ������һ������
		 *{}�����壬���������󲿷���Ĺ���
		 */
		Xoo xoo = new Xoo(){
			public String toString(){
				return "I am Xoo";
			}
		};
	}
}

class Xoo{}
//class Yoo extends Xoo{}

















































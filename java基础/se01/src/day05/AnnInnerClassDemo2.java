package day05;

public class AnnInnerClassDemo2 {
	public static void main(String[] args) {
		//�����ڲ���д�ڷ����о���һ������ľֲ��ڲ���
		final int a = 2;
		//�ӳ�����̳е������ڲ���
		Yoo yoo = new Yoo(){   //�Ը������ʽд
			//public Yoo(){} //����д������
			//java�еļ̳з����ķ�Χ���ԷŴ󣬵��ǲ�����С
			public int add() {
				return a+1;
			}
		};
		//�ӽӿ�ʵ�ֵ��������ڲ���
		Koo koo = new Koo(){ 
			public int add(){
				return a+1;
			}
		};
		
		
	}
}

interface Koo{
	int add();
}
abstract class Yoo{protected abstract int add();}






















































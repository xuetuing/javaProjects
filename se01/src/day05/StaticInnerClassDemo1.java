package day05;
//��̬�ڲ���
public class StaticInnerClassDemo1 {
	public static void main(String[] args) {
		Foo.Koo koo = new Foo.Koo();//��д�ص�
		System.out.println(koo.add());
	}
}
/*
 * Koo����Foo�ľ�̬�ڲ��࣬Foo�൱��Koo�İ���ΪKoo����
 * ��һ�������ռ䣬��̬�ڲ���������������ھ�̬����������غ�
 * �ʹ��ڣ������ھ�̬�ڲ����з����ⲿ��ľ�̬��Ա
 */
class Foo{
	int a = 1;
	static int b = 2;
	static class Koo{  
		int add(){
			//return a+b;
			return 1+b;
		}
	}
}
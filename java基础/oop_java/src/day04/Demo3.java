package day04;

public class Demo3 {
	public static void main(String[] args) {
		Foo f1 = new Foo();
		f1.a = 1; //f1.a �������ʱ��ʼ��   
		f1.b = 1;
		System.out.println(f1.b);//f1.b,��������������ʱ��ʼ��b
		Foo f2 = new Foo();
		f2.a++;
		f2.b++;
		System.out.println(f2.a);//2
		System.out.println(f2.b);//1
		f1(); //demo3.f1();ͬһ�����У���������ʡ��
	}
	public static void f1(){
		
	}
}

class Foo{
	static int a;
	int b;
}
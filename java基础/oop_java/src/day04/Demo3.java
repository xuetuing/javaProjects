package day04;

public class Demo3 {
	public static void main(String[] args) {
		Foo f1 = new Foo();
		f1.a = 1; //f1.a 在类加载时初始化   
		f1.b = 1;
		System.out.println(f1.b);//f1.b,构造器产生对象时初始化b
		Foo f2 = new Foo();
		f2.a++;
		f2.b++;
		System.out.println(f2.a);//2
		System.out.println(f2.b);//1
		f1(); //demo3.f1();同一个类中，类名可以省略
	}
	public static void f1(){
		
	}
}

class Foo{
	static int a;
	int b;
}
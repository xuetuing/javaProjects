package day05;
//静态内部类
public class StaticInnerClassDemo1 {
	public static void main(String[] args) {
		Foo.Koo koo = new Foo.Koo();//书写特点
		System.out.println(koo.add());
	}
}
/*
 * Koo就是Foo的静态内部类，Foo相当于Koo的包，为Koo声明
 * 了一个命名空间，静态内部类的作用域，类似于静态变量，类加载后
 * 就存在，可以在静态内部类中访问外部类的静态成员
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
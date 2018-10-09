package day05;

import day05.Goo.Moo;

//成员内部类
public class InnerClassDemo {
	public static void main(String[] args) {
		//成员变量必须要有实例才能调用
//		Moo moo = new Moo();
		Goo goo = new Goo();
		//必须使用goo实例才能创建Moo对象
		Moo moo = goo.new Moo();  //书写特点
		//goo创建的Moo实例可以访问goo实例的属性
		System.out.println(moo.add());
		
		Goo goo2 = new Goo();
		goo2.a = 2;
		Moo moo2 = goo2.new Moo();
		System.out.println(moo2.add());
	}
}
/*
 * Moo就是Goo的成员内部类，就是普通内部类
 * 成员内部类与实例变量具有相同的作用域
 */
class Goo{
	int a = 1;
	static int b = 2;
	class Moo{
		//成员内部类的优点：可以共享外部类的成员变量
		int add(){
			return a+b;
		}
	}
}
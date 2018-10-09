package test;

import java.util.Date;

public class Test1 extends Date{
	public static void main(String[] args) {
		//new Test1().test();
		
		//字符串加法运算在编译器的优化
		String s1 = "a";
		String s2 = s1 + "b";  //创建了新对象
		String s3 = "a" + "b";  
		String s4 = "ab";
		System.out.println(s1=="a"); //true
		System.out.println(s2=="ab"); //false，两个对象的地址是不一样的
		System.out.println(s3=="ab"); //true  编译期优化，没有创建新对象
		System.out.println(s2==s3);  //false
		System.out.println(s3==s4); // true
		
	}
	public void test(){
		//由于 getClass()在 Object类中定义成了 final，子类不能覆盖该方法
		System.out.println(super.getClass().getName());
		System.out.println(getClass().getSuperclass().getName());
		
	}
}

package day05;

import java.util.Arrays;
import java.util.Comparator;

public class LocalInnerClassDemo {
	public static void main(String[] args) {
		//局部内部类可以共享访问外部方法的局部变量，局部变量必须是final修饰的
		final int a = 1;
		//在方法中声明的内部类，作用域类似于局部变量
		class Foo{
			int b = 1;
			public int add(){
				return a+b;
			}
		}
		Foo f = new Foo();
		System.out.println(f.add());
		
		String[] names = {"Andy","Jack","Rose","Tom"};
		class sortByCode implements Comparator<String>{
			public int compare(String o1, String o2) {
				return o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
			}
			
		}
		Arrays.sort(names,new sortByCode());
		System.out.println(Arrays.toString(names));
		
	}
}

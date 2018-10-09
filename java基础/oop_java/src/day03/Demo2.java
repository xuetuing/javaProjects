package day03;

import day02.sub.Yoo;
public class Demo2 {
	public static void main(String[] args) {
		Xoo xoo = new Xoo();
		//System.out.println(xoo.a);
		System.out.println(xoo.b);
		System.out.println(xoo.c);
		System.out.println(xoo.d);
		xoo.test();		
		Yoo yoo = new Yoo();
		//System.out.println(yoo.a);
		//System.out.println(yoo.b);
		//System.out.println(yoo.c);
		System.out.println(yoo.d);
		yoo.test();
		
	}
}

class Xoo{
	private int a = 1;
	int b = 1;
	protected int c = 1;
	public int d = 1;
	public void test(){
		System.out.println(a);
	}
}	































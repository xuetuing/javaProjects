package day04;

public class Demo5 {
	public static final int LEET_UP = 0; //常量
	public final static int LEET_DP = 0;
	public static void main(String[] args) {
		final int a = 1;
		//a++;
	}
}

//class MyString extends String{}
class Aoo{
	public final int add(int a,int b){
		return a+b;
	}
}

class Moo extends Aoo{
//	public int add(int a,int b){  //不能重写final修饰的方法
//		return a*b;
//	}
}
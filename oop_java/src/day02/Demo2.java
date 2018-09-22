package day02;

public class Demo2 {
	public static void main(String[] args) {
		Eoo eoo = new Eoo();
		System.out.println(eoo.add('0',1));
	}
}

class Eoo{
	public long add(long a,int b){
		System.out.println("调用的是add2的方法");
		return a+b;
	}
	public int add(int a,int b){
		System.out.println("调用的是add1的方法");
		return a+b;
	}
	public int add(int a){
		System.out.println("调用的是add3的方法");
		return a+a;
	}
}
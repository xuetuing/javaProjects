package day02;

public class Demo2 {
	public static void main(String[] args) {
		Eoo eoo = new Eoo();
		System.out.println(eoo.add('0',1));
	}
}

class Eoo{
	public long add(long a,int b){
		System.out.println("���õ���add2�ķ���");
		return a+b;
	}
	public int add(int a,int b){
		System.out.println("���õ���add1�ķ���");
		return a+b;
	}
	public int add(int a){
		System.out.println("���õ���add3�ķ���");
		return a+a;
	}
}
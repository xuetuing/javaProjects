package day02;

public class Demo3 {
	public static void main(String[] args) {
		int a = 1;
		int c = add(a); //2
		Koo koo = new Koo();
		int d = add(koo);//2
		System.out.println(a+","+koo.a+","+c+","+d);//1 2 2 2
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(Koo koo){
		Koo k = koo;
		k.a++;
		return koo.a;
	}
}

class Koo{
	int a=1;
}
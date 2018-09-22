package day01;

public class TestSingleton {
	public static void main(String[] args) {
//		Singleton t1 = new Singleton();
//		Singleton t2 = new Singleton();
//		Singleton t1 = Singleton.instance;
		Singleton t1 = Singleton.getInstance();
		Singleton t2 = Singleton.getInstance();
		System.out.println(t1==t2);
	}
}
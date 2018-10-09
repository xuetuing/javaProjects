package pattern;
//����ģʽ
public class Singleton {

	private Singleton() {}
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}
	public void print(){
		System.out.println("����ģʽ");
	}
}

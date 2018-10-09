package day01;
//单例模式
public class Singleton {
	//私有化构造器
	private Singleton() {}
//	static Singleton instance = new Singleton();
	//声明一个私有的静态的当前类型实例
	private static Singleton instance = new Singleton();
	//声明公有的静态的能够返回当前类型实例的方法
	public static Singleton getInstance(){
		return instance;
	}
}

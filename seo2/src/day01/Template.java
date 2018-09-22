package day01;
/*
 * 模板模式，控制方法
 * 相同步骤在主类中设置好模板，具体方法则设置抽象类到子类实现
 */
public abstract class Template {
	public void sayHello(){
		System.out.println("大家好！");
		sayName();
		sayInfo();
		System.out.println("谢谢！再见");
	}
	
	public abstract void sayName();
	public abstract void sayInfo();
	
	
}

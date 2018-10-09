package testdemo;

public class Transtale {
	public static void main(String[] args) {
		Ay a = new By(); //向上转型
		a.f1();  //只要被子类重写，就调用子类方法
		//a.f2();  //向上转型只能使用父类中的方法
		By b = (By)a;//向下转型子类和父类的函数都能访问
		b.f1();
		b.f2();
		
//		Ay a1 = new Ay();
//		By b1 = (By)a1; //这种写法是错误的
//		b1.f1();
//		b1.f2();
		
	}
	
}

class Ay{
	public void f1(){
		System.out.println("A类函数");
	}
}

class By extends Ay{
	public void f1(){
		System.out.println("B类函数");
	}
	public void f2(){
		System.out.println("B类函数");
	}
}
package day02;

//当父类型变量引用子类型实例的时候，不能调用子类类型对象的特有属性和方法
//变量类型上声明的方法，才能通过编译，可以调用
public class Demo4 {
	public static void main(String[] args) {
		Sub s = new Sub();
		Super ss = new Sub();  //向上转型，只能调用父类的属性和方法
		System.out.println(s.x);
		s.a();
		//ss.t(); //编译错误，Super类型没有定义t();
		Sub sub = null;
		//sub.t();//能编译通过，但运行时会出现空指针异常
		sub = (Sub)s; //一个对象被两个变量引用
		sub.t(); //sub类型上有t(),可以编译调用
		
		
	}
}

class Super{
	int x = 1;
	public void a(){
		System.out.println("super a()");
	}
}

class Sub extends Super{
	int b;
	public void t(){
		System.out.println("sub t()");
	}
}
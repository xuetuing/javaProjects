package day02;

//子类构造器默认调用父类构造器
public class Demo5 {
	public static void main(String[] args) {
		new Hoo();
	}
}

class Joo{
	public Joo(int a){
		System.out.println("Joo(int a)");
	}
}

class Hoo extends Joo{ //编译错误，父类没有无参构造器
	public Hoo(){
		///super();//错误，调用父类的无参构造器
		super(5);//正确，主动调用有参，只能放在第一行
		System.out.println("Hoo()");
	}
	
}
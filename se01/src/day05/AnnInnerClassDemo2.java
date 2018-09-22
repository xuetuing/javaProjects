package day05;

public class AnnInnerClassDemo2 {
	public static void main(String[] args) {
		//匿名内部类写在方法中就是一个特殊的局部内部类
		final int a = 2;
		//从抽象类继承的匿名内部类
		Yoo yoo = new Yoo(){   //以父类的形式写
			//public Yoo(){} //不能写构造器
			//java中的继承方法的范围可以放大，但是不能缩小
			public int add() {
				return a+1;
			}
		};
		//从接口实现的匿名的内部类
		Koo koo = new Koo(){ 
			public int add(){
				return a+1;
			}
		};
		
		
	}
}

interface Koo{
	int add();
}
abstract class Yoo{protected abstract int add();}






















































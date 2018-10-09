package day05;

public class AnnInnerClassDemo {
	public static void main(String[] args) {
		/*
		 *匿名内部类：
		 *new Xoo(){}是对Xoo的继承，并且实例化
		 *new Xoo(){}是Xoo的子类实例，是一个对象
		 *{}是类体，可以声明大部分类的功能
		 */
		Xoo xoo = new Xoo(){
			public String toString(){
				return "I am Xoo";
			}
		};
	}
}

class Xoo{}
//class Yoo extends Xoo{}

















































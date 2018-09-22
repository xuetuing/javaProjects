package day03;

public class Demo3 {
	public static void main(String[] args) {
		Circle c = new Circle();
		Shape s = c;  //向上转型   多态性
		
		Shape s1 = new Circle();
		Circle c1 = (Circle)s1; //向下转型（强制）
		
//		s1 = new Rectangle();
//		c1 = (Circle)s1;//编译没有错误，但是运行时有类转换异常
		
		Shape s2 = new Circle();
		foo(s2);
	}
	public static void foo(Shape s){
		if(s instanceof Circle){
			Circle c = (Circle)s;
			System.out.println("可以强转");
		}else{
			System.out.println("不可以强转"); 
		}
	}
}

class Shape{}
class Circle extends Shape{}
class Rectangle extends Shape{}


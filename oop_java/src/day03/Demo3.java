package day03;

public class Demo3 {
	public static void main(String[] args) {
		Circle c = new Circle();
		Shape s = c;  //����ת��   ��̬��
		
		Shape s1 = new Circle();
		Circle c1 = (Circle)s1; //����ת�ͣ�ǿ�ƣ�
		
//		s1 = new Rectangle();
//		c1 = (Circle)s1;//����û�д��󣬵�������ʱ����ת���쳣
		
		Shape s2 = new Circle();
		foo(s2);
	}
	public static void foo(Shape s){
		if(s instanceof Circle){
			Circle c = (Circle)s;
			System.out.println("����ǿת");
		}else{
			System.out.println("������ǿת"); 
		}
	}
}

class Shape{}
class Circle extends Shape{}
class Rectangle extends Shape{}


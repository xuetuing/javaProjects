package day02;

public class CircleDemo {
	public static void main(String[] args) {
		Point center = new Point(3,4);
		Point p = new Point(10,10);
		Circle c = new Circle(center,5);
		double area = c.area();
		System.out.println("Բ���Ϊ��"+area);
		c.contains(10,10);
		c.contains(p);
	}
}

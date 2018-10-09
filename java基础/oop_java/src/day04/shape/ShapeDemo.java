package day04.shape;

public class ShapeDemo {
	public static void main(String[] args) {
		//Shape s = new Shape();
		Shape s = new Circle(3,4,5);
		System.out.println(s.area());
		Point p = new Point(7,8);
		System.out.println(s.contains(p));
		
		s = new Rectangle(3,4,8,10);
		System.out.println(s.area());
		Point p1 = new Point(7,8);
		System.out.println(s.contains(p));
	}
}

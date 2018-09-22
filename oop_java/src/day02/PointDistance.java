package day02;

public class PointDistance {
	public static void main(String[] args) {
		Point p0 = new Point(3,4);
		Point p1 = new Point(2,4);
		System.out.println(p0.distance());
		System.out.println(p0.distance(p1.x,p1.y));
		System.out.println(p0.distance(p1));
	}
}
